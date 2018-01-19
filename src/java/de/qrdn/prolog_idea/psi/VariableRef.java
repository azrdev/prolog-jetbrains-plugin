package de.qrdn.prolog_idea.psi;

import com.intellij.psi.PsiElement;
import de.qrdn.prolog_idea.psi.IdentifierPSINode;
import de.qrdn.prolog_idea.psi.PrologElementRef;
import org.jetbrains.annotations.NotNull;

public class VariableRef extends PrologElementRef {
	public VariableRef(@NotNull IdentifierPSINode element) {
		super(element);
	}

	@Override
	public boolean isDefSubtree(PsiElement def) {
		return def instanceof VardefSubtree;
	}
}
