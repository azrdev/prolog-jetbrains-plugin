package de.qrdn.prolog_idea.structview;

import com.intellij.ide.structureView.StructureViewModel;
import com.intellij.ide.structureView.StructureViewModelBase;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.Sorter;
import de.qrdn.prolog_idea.psi.PrologPSIFileRoot;
import de.qrdn.prolog_idea.structview.PrologStructureViewRootElement;
import org.jetbrains.annotations.NotNull;

public class PrologStructureViewModel
	extends StructureViewModelBase
	implements StructureViewModel.ElementInfoProvider
{
	public PrologStructureViewModel(PrologPSIFileRoot root) {
		super(root, new PrologStructureViewRootElement(root));
	}

	@NotNull
	public Sorter[] getSorters() {
		return new Sorter[] {Sorter.ALPHA_SORTER};
	}

	@Override
	public boolean isAlwaysLeaf(StructureViewTreeElement element) {
  		return !isAlwaysShowsPlus(element);
	}

	@Override
	public boolean isAlwaysShowsPlus(StructureViewTreeElement element) {
		Object value = element.getValue();
  		return value instanceof PrologPSIFileRoot;
	}
}
