package de.qrdn.prolog_idea.structview;

import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement;
import com.intellij.ide.util.treeView.smartTree.TreeElement;
import com.intellij.navigation.ItemPresentation;
import com.intellij.navigation.NavigationItem;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import org.antlr.jetbrains.adaptor.xpath.XPath;
import de.qrdn.prolog_idea.PrologLanguage;
import de.qrdn.prolog_idea.psi.PrologPSIFileRoot;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PrologStructureViewElement implements StructureViewTreeElement, SortableTreeElement {
	protected final PsiElement element;

	public PrologStructureViewElement(PsiElement element) {
		this.element = element;
	}

	@Override
	public Object getValue() {
		return element;
	}

	@Override
	public void navigate(boolean requestFocus) {
		if (element instanceof NavigationItem ) {
			((NavigationItem) element).navigate(requestFocus);
		}
	}

	@Override
	public boolean canNavigate() {
		return element instanceof NavigationItem &&
			   ((NavigationItem)element).canNavigate();
	}

	@Override
	public boolean canNavigateToSource() {
		return element instanceof NavigationItem &&
			   ((NavigationItem)element).canNavigateToSource();
	}

	@NotNull
	@Override
	public String getAlphaSortKey() {
		String s = element instanceof PsiNamedElement ? ((PsiNamedElement) element).getName() : null;
		if ( s==null ) return "unknown key";
		return s;
	}

	@NotNull
	@Override
	public ItemPresentation getPresentation() {
		return new PrologItemPresentation(element);
	}

	@NotNull
	@Override
	public TreeElement[] getChildren() {
		if ( element instanceof PrologPSIFileRoot) {
			Collection<? extends PsiElement> funcs = XPath.findAll(PrologLanguage.INSTANCE, element, "/script/function/ID");
			List<TreeElement> treeElements = new ArrayList<>(funcs.size());
			for (PsiElement el : funcs) {
				treeElements.add(new PrologStructureViewElement(el));
			}
			return treeElements.toArray(new TreeElement[funcs.size()]);
		}
		return new TreeElement[0];
	}
}
