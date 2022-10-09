# Test for Google Homepage component

## About
This is a test automation framework includes ui Tests for Google Homepage -> www.google.com

## Requirements
| Plugin | README |
| ------ | ------ |
| Java 11 | https://www.oracle.com/java/technologies/javase-downloads.html |
| Maven Project | https://maven.apache.org/download.cgi |

## Execution
To trigger the tests on local environment use follow command:
```sh
mvn test
```
This command will download [chromedriver](https://chromedriver.chromium.org) and trigger your tests against Google Chrome

You can also trigger the test against [Selenium Grid](https://www.selenium.dev/documentation/en/grid/) using following command:
```sh
mvn test -Dgrid.url=[url]
```
where:
- `[url]` - link to your Selenium Grid instance, example: http://localhost:4444/wd/hub  

## License
MIT
