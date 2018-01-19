package de.qrdn.prolog_idea.structview;

import com.intellij.ide.structureView.StructureViewBuilder;
import com.intellij.ide.structureView.StructureViewModel;
import com.intellij.ide.structureView.TreeBasedStructureViewBuilder;
import com.intellij.lang.PsiStructureViewFactory;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiFile;
import de.qrdn.prolog_idea.psi.PrologPSIFileRoot;
import de.qrdn.prolog_idea.structview.PrologStructureViewModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PrologStructureViewFactory implements PsiStructureViewFactory {
	@Nullable
	@Override
	public StructureViewBuilder getStructureViewBuilder(final PsiFile psiFile) {
		return new TreeBasedStructureViewBuilder() {
			@NotNull
			@Override
			public StructureViewModel createStructureViewModel(@Nullable Editor editor) {
				return new PrologStructureViewModel((PrologPSIFileRoot)psiFile);
			}
		};
	}
}
