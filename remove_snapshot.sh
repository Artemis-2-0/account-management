#!/bin/bash

POM_FILE="pom.xml"

# Remove -SNAPSHOT from the version below <artifactId>account-management</artifactId>
awk '
    /<artifactId>account-management<\/artifactId>/ { found=1 }
    found && /<version>/ && !updated {
        sub(/-SNAPSHOT/, "", $0)
        updated=1
    }
    { print }
' "$POM_FILE" > pom.xml.tmp && mv pom.xml.tmp "$POM_FILE"

echo "Removed -SNAPSHOT from version."