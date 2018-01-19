package de.qrdn.prolog_idea;

import com.intellij.lang.Language;

public class PrologLanguage extends Language {
    public static final PrologLanguage INSTANCE = new PrologLanguage();

    private PrologLanguage() {
        super("Prolog");
    }
}
