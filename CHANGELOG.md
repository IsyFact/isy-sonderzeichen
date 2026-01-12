# 5.0.0

## [5.0.0]

### /^### [(dependency upgrades|DEPENDENCY UPGRADES)]

- Bump `actions/checkout` from 4 to 6 ([#132](https://github.com/IsyFact/isy-sonderzeichen/pull/132))
### FEATURES
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

### BREAKING CHANGES
- `IFS-4922`: Aktualisierung von Java 17 auf 25

### DOKUMENTATION
- `IFS-4764`: Bereinigung technischer Schulden

### DEPENDENCY UPGRADES
- Update IsyFact/isy-github-actions-templates/.github/workflows/maven_dependency_scan_template.yml von Version 1.7.0 auf 1.8.0
