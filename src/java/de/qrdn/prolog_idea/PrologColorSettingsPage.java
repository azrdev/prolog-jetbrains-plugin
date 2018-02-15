package de.qrdn.prolog_idea;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import de.qrdn.prolog_idea.parser.PrologSyntaxHighlighter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

public class PrologColorSettingsPage implements ColorSettingsPage {
	private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
		new AttributesDescriptor("Number", PrologSyntaxHighlighter.NUMBER),
		new AttributesDescriptor("Variable", PrologSyntaxHighlighter.VARIABLE),
		new AttributesDescriptor("Atom", PrologSyntaxHighlighter.ATOM),
		new AttributesDescriptor("String", PrologSyntaxHighlighter.STRING),
		new AttributesDescriptor("Line comment", PrologSyntaxHighlighter.LINE_COMMENT),
		new AttributesDescriptor("Block comment", PrologSyntaxHighlighter.BLOCK_COMMENT),
	};

	@Nullable
	@Override
	public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
		return null;
	}

	@Nullable
	@Override
	public Icon getIcon() {
		return null;
	}

	@NotNull
	@Override
	public SyntaxHighlighter getHighlighter() {
		return new PrologSyntaxHighlighter();
	}

	@NotNull
	@Override
	public String getDemoText() {
		return
			"/* block comment */\n" +
			"% line comment\n" +
			"fact(is, true).\n" +
			"rule(A, B) :-\n" +
			"  'quoted atom'(A) ,\n" +
			"  atom(B) ;\n" +
			"  body( [A, _] )\n" +
			"  .\n" +
			"lists( \"double quoted list\", {'curly bracketed list'} ).\n" +
			"integers([ 12345, 0'ü, 0b1101, 0o777, 0xdeadbeef ]).\n" +
			"float( 12345.54321e-10 ).\n" +
			//TODO: operator syntax highlighting example
			"graphic_tokens( #, \\\\, $, &, *, +, ., /, :, <=>, ?@^~, - ).\n" +
			":- directive.\n"
			;
	}

	@NotNull
	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		return DESCRIPTORS;
	}

	@NotNull
	@Override
	public ColorDescriptor[] getColorDescriptors() {
		return ColorDescriptor.EMPTY_ARRAY;
	}

	@NotNull
	@Override
	public String getDisplayName() {
		return "Prolog";
	}
}
