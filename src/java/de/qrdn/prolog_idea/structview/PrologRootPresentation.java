package de.qrdn.prolog_idea.structview;

import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiFile;
import de.qrdn.prolog_idea.Icons;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class PrologRootPresentation implements ItemPresentation {
	protected final PsiFile element;

	protected PrologRootPresentation(PsiFile element) {
		this.element = element;
	}

	@Nullable
	@Override
	public Icon getIcon(boolean unused) {
		return Icons.PROLOG_ICON;
	}

	@Nullable
	@Override
	public String getPresentableText() {
		return element.getVirtualFile().getNameWithoutExtension();
	}

	@Nullable
	@Override
	public String getLocationString() {
		return null;
	}
}
