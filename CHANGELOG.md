# 4.1.0
### Features
- `IFS-4709`: Kennzeichnung der Lizenz vereinheitlichen
- `IFS-4531`: Update von Flatten Maven Plugin auf Version 1.7.1
- `IFS-4804`: Update der Third Party Dependencies:
    * org.codehaus.mojo:flatten-maven-plugin von 1.7.1 auf 1.7.2
    * org.codehaus.mojo:tidy-maven-plugin von 1.3.0 auf 1.4.0
    * net.logstash.logback:logstash-logback-encoder von 8.0 auf 8.1
    * org.apache.maven.plugins:maven-compiler-plugin von 3.11.0 auf 3.14.0
    * org.slf4j:slf4j-api von 2.0.13 auf 2.0.17
    * org.apache.maven.plugins:maven-gpg-plugin von 3.0.1 auf 3.2.8
    * org.apache.maven.plugins:maven-enforcer-plugin von 3.5.0 auf 3.6.1

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
