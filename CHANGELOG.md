# GitAutoLink Changelog

## Unreleased

## 0.7.3

- Bugfix: Fix the missing settings display name error during IntelliJ IDEA 2026.2.4 startup by declaring the display name in the plugin descriptor.

## 0.7.2

- Support IntelliJ 2024.2 - 2026.2 (dropped support for 2023.1 - 2024.1)
- Upgrade Gradle to 9.8.2
- Upgrade IntelliJ Platform Gradle Plugin to 2.19.0
- Fix test execution by adding JUnit 4 runtime dependency

## 0.7.1

- Bugfix: Fixed `ArrayIndexOutOfBoundsException` in Open in Browser action when no commit is selected.

## 0.7.0

- Support IntelliJ 2024.
- Upgrade platformVersion to 2024.3
- Upgrade gradle to 8.10
- Upgrade Kotlin to 2.0.21
- Upgrade JDK 21

## 0.6.0

- Support IntelliJ 2024.2

## 0.5.0

- Support IntelliJ 2024.1
- Add ActionUpdateThread to BrowserAction

## 0.4.0

- Feature: Can do regular expressions on key values.

## 0.3.0

- If right delimiter value is empty, search for `' '`

## 0.2.0

- Changed setting from Application to Project.

## 0.1.3

- Bugfix: Resolved an issue where a multi-character left delimiter was not being recognized.

## 0.1.2

- Support versions from 2022.3 onwards

## 0.1.1

- Added plugin icon

## 0.1.0

- Correction of typos

## 0.0.9

- Check compatibility

## 0.0.8

- Performance improvements

## 0.0.7

- Activate when a link is found in the text

## 0.0.6

- Add changelog
