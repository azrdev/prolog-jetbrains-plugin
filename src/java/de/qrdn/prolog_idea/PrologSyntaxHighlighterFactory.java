package de.qrdn.prolog_idea;

import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import de.qrdn.prolog_idea.parser.PrologSyntaxHighlighter;
import org.jetbrains.annotations.NotNull;

public class PrologSyntaxHighlighterFactory extends SyntaxHighlighterFactory {
    @NotNull
    @Override
    public SyntaxHighlighter getSyntaxHighlighter(Project project, VirtualFile virtualFile) {
        return new PrologSyntaxHighlighter();
    }
}
