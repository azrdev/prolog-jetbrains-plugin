package de.qrdn.prolog_idea.structview;

import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;

public class PrologStructureViewRootElement extends PrologStructureViewElement {
	public PrologStructureViewRootElement(PsiFile element) {
		super(element);
	}

	@NotNull
	@Override
	public ItemPresentation getPresentation() {
		return new PrologRootPresentation((PsiFile)element);
	}
}
