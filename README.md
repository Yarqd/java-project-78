### Hexlet tests and linter status:

[![Actions Status](https://github.com/Yarqd/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/Yarqd/java-project-78/actions)
<a href="https://codeclimate.com/github/Yarqd/java-project-78/maintainability"><img src="https://api.codeclimate.com/v1/badges/534f2ac748fb305c5997/maintainability" /></a>
<a href="https://codeclimate.com/github/Yarqd/java-project-78/test_coverage"><img src="https://api.codeclimate.com/v1/badges/534f2ac748fb305c5997/test_coverage" /></a>

Project Description
Overview
This project is a validation library that provides flexible and reusable schemas for validating different types of data. The library includes support for validating strings, numbers, and maps, with capabilities to extend to other data types as needed.

Features
String Validation: Validate strings with options for required fields, minimum length, and substring presence.
Number Validation: Validate numbers with options for required fields, positivity, and range.
Map Validation: Validate maps with options for required fields and size, as well as nested validation for map values.
Usage
To use this library, create an instance of the Validator class and define schemas for the data you want to validate. The library uses method chaining to add validation rules to schemas. Once the schema is defined, you can validate data against it.
