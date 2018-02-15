package de.qrdn.prolog_idea.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import org.antlr.jetbrains.adaptor.SymtabUtils;
import org.antlr.jetbrains.adaptor.psi.ScopeNode;
import de.qrdn.prolog_idea.PrologFileType;
import de.qrdn.prolog_idea.PrologLanguage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class PrologPSIFileRoot extends PsiFileBase implements ScopeNode {
    public PrologPSIFileRoot(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, PrologLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return PrologFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Prolog file";
    }

    @Override
    public Icon getIcon(int flags) {
        return null;
    }

	/** Return null since a file scope has no enclosing scope. It is
	 *  not itself in a scope.
	 */
	@Override
	public ScopeNode getContext() {
		return null;
	}

	@Nullable
	@Override
	public PsiElement resolve(PsiNamedElement element) {
		return SymtabUtils.resolve(this, PrologLanguage.INSTANCE,
		                           element, "/p_text/clause/term/atom/LETTER_DIGIT");//TODO: other def types
	}
}
