# 4.1.0
### Features
- `IFS-4709`: Kennzeichnung der Lizenz vereinheitlichen
- `IFS-4531`: Update von Flatten Maven Plugin auf Version 1.7.1

## Dokumentation
- `IFS-4764`: Bereinigung technischer Schulden

## Migrationsleitfaden

### `IFS-4764`: Bereinigung technischer Schulden
Für das Release 4.1.0 muss die Online-Dokumentation angepasst werden.

#### Dokumentation
- Die Antora-Komponente von `isy-sonderzeichen` heißt jetzt `datetime` anstatt `isy-sonderzeichen-docs`.
- Das Konzept wird mittels `konzept.adoc` anstatt `konzept/master.adoc` referenziert.
- Die Nutzungsvorgaben werden mittels `nutzungsvorgaben.adoc` anstatt `nutzungsvorgaben/master.adoc` referenziert.
- Die Tabellen werden mittels `nutzungsvorgaben/tabellen.adoc` anstatt über die Nutzungsvorgaben referenziert.

#### Playbook
- Der Parameter `start_path` der Content Source für `isy-sonderzeichen` muss auf `docs` anstatt `isy-sonderzeichen-doc` gesetzt werden.

#### Build
- `.github/workflows/antora-build.yml`: `sparse-checkout` muss auf `docs` anstatt `isy-sonderzeichen-doc` gesetzt werden.
