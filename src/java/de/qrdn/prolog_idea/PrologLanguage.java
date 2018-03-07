package de.qrdn.prolog_idea;

import org.intellij.lang.annotations.Language;

public class PrologLanguage extends Language {
    public static final PrologLanguage INSTANCE = new PrologLanguage();

    private PrologLanguage() {
        super("Prolog");
    }
}
