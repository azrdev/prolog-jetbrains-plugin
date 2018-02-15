package de.qrdn.prolog_idea.parser;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import de.qrdn.prolog_idea.PrologParserDefinition;
import org.antlr.jetbrains.adaptor.lexer.ANTLRLexerAdaptor;
import org.antlr.jetbrains.adaptor.lexer.PSIElementTypeFactory;
import org.antlr.jetbrains.adaptor.lexer.TokenIElementType;
import de.qrdn.prolog_idea.PrologLanguage;
import org.jetbrains.annotations.NotNull;
import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;


/** A highlighter is really just a mapping from token type to
 *  some text attributes using {@link #getTokenHighlights(IElementType)}.
 *  The reason that it returns an array, TextAttributesKey[], is
 *  that you might want to mix the attributes of a few known highlighters.
 *  A {@link TextAttributesKey} is just a name for that a theme
 *  or IDE skin can set. For example, {@link com.intellij.openapi.editor.DefaultLanguageHighlighterColors#KEYWORD}
 *  is the key that maps to what identifiers look like in the editor.
 *  To change it, see dialog: Editor > Colors & Fonts > Language Defaults.
 *
 *  From <a href="http://www.jetbrains.org/intellij/sdk/docs/reference_guide/custom_language_support/syntax_highlighting_and_error_highlighting.html">doc</a>:
 *  "The mapping of the TextAttributesKey to specific attributes used
 *  in an editor is defined by the EditorColorsScheme class, and can
 *  be configured by the user if the plugin provides an appropriate
 *  configuration interface.
 *  ...
 *  The syntax highlighter returns the {@link TextAttributesKey}
 * instances for each token type which needs special highlighting.
 * For highlighting lexer errors, the standard TextAttributesKey
 * for bad characters HighlighterColors.BAD_CHARACTER can be used."
 */
public class PrologSyntaxHighlighter extends SyntaxHighlighterBase {
	private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];
	public static final TextAttributesKey NUMBER =
		createTextAttributesKey("PROLOG_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
	public static final TextAttributesKey VARIABLE =
		createTextAttributesKey("PROLOG_VARIABLE", DefaultLanguageHighlighterColors.IDENTIFIER);
	public static final TextAttributesKey ATOM =
		createTextAttributesKey("PROLOG_ATOM", DefaultLanguageHighlighterColors.KEYWORD);
	public static final TextAttributesKey STRING =
		createTextAttributesKey("PROLOG_STRING", DefaultLanguageHighlighterColors.STRING);
	public static final TextAttributesKey LINE_COMMENT =
		createTextAttributesKey("PROLOG_LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
	public static final TextAttributesKey BLOCK_COMMENT =
		createTextAttributesKey("PROLOG_BLOCK_COMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT);

	static {
		PSIElementTypeFactory.defineLanguageIElementTypes(PrologLanguage.INSTANCE,
		                                                  PrologParser.tokenNames,
		                                                  PrologParser.ruleNames);
	}

	@NotNull
	@Override
	public Lexer getHighlightingLexer() {
		PrologLexer lexer = new PrologLexer(null);
		return new ANTLRLexerAdaptor(PrologLanguage.INSTANCE, lexer);
	}

	@NotNull
	@Override
	public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
		if ( !(tokenType instanceof TokenIElementType) ) return EMPTY_KEYS;
		TokenIElementType myType = (TokenIElementType)tokenType;
		int ttype = myType.getANTLRTokenType();
		TextAttributesKey attrKey;
		if(PrologParserDefinition.STRING.contains(myType))
			return new TextAttributesKey[]{STRING};
		switch ( ttype ) {
			case PrologLexer.DECIMAL :
			case PrologLexer.CHARACTER_CODE_CONSTANT :
			case PrologLexer.BINARY :
			case PrologLexer.OCTAL :
			case PrologLexer.HEX :
			case PrologLexer.FLOAT :
				attrKey = NUMBER;
				break;
			case PrologLexer.VARIABLE :
				attrKey = VARIABLE;
				break;
			case PrologLexer.LETTER_DIGIT :
			case PrologLexer.GRAPHIC_TOKEN :
				attrKey = ATOM;
				break;
			case PrologLexer.COMMENT :
				attrKey = LINE_COMMENT;
				break;
			case PrologLexer.MULTILINE_COMMENT :
				attrKey = BLOCK_COMMENT;
				break;
			default :
				return EMPTY_KEYS;
		}
		return new TextAttributesKey[] {attrKey};
	}
}
