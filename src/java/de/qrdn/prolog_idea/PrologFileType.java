package de.qrdn.prolog_idea;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class PrologFileType extends LanguageFileType {
	public static final String FILE_EXTENSION = "pl";
	public static final PrologFileType INSTANCE = new PrologFileType();

	protected PrologFileType() {
		super(PrologLanguage.INSTANCE);
	}

	@NotNull
	@Override
	public String getName() {
		return "Prolog file";
	}

	@NotNull
	@Override
	public String getDescription() {
		return "Prolog file";
	}

	@NotNull
	@Override
	public String getDefaultExtension() {
		return FILE_EXTENSION;
	}

	@Nullable
	@Override
	public Icon getIcon() {
		return null;
	}
}
