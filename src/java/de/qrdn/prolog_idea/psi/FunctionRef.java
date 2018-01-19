package de.qrdn.prolog_idea.psi;

import com.intellij.psi.PsiElement;
import de.qrdn.prolog_idea.psi.IdentifierPSINode;
import de.qrdn.prolog_idea.psi.PrologElementRef;
import org.jetbrains.annotations.NotNull;

/** A reference object associated with (referring to) a IdentifierPSINode
 *  underneath a call_expr rule subtree root.
 */
public class FunctionRef extends PrologElementRef {
	public FunctionRef(@NotNull IdentifierPSINode element) {
		super(element);
	}

	@Override
	public boolean isDefSubtree(PsiElement def) {
		return def instanceof FunctionSubtree;
	}
}
