# java-refactoring-to-patterns

* [패턴을 활용한 리팩터링 - 조슈아 케리에브스키](http://www.yes24.com/Product/Goods/14752528) 예제 코드
* README 목록
  * [책 목차](https://github.com/viiviii/java-refactoring-to-patterns#Table-of-Contents)
  * [Note](https://github.com/viiviii/java-refactoring-to-patterns#Note)
  * [Shell script 설명](https://github.com/viiviii/java-refactoring-to-patterns#Shell-script-descriptions)
  * [Other package 설명](https://github.com/viiviii/java-refactoring-to-patterns#Other-package-descriptions)
  
---

### Table-of-Contents
> 💡 Markdown style 의미   
>   - 리팩터링 방향 - **목표**, ~~제거~~

| Chapter     | Contents                                               | Code smell        | Summary               |
|-------------|--------------------------------------------------------|-------------------|-----------------------|
| 06.creation | Replace Constructors with **Creation Methods**         |                   | `Loan`                |
|             | Move Creation Knowledge to **Factory**                 | 문어발 솔루션         | `NodeFactory`         |
|             | Encapsulate Classes with **Factory**                   | 추잡한 노출          | `AttributeDescriptor` |
|             | Introduce Polymorphic Creation with **Factory Method** | 중복된 코드          | `AbstractBuilderTest` |
|             | Encapsulate ~~Composite~~ with **Builder**             | 기본 타입 강박관념     | `TagBuilder`          |
|             | Inline ~~Singleton~~                                   | 게으른 클래스         | `Console`             |


### Note
* 이 예제 코드는 책을 기반으로 하였으나 책에서 나오지 않은 부분은 개인의 생각대로 stub 구현되었습니다.
* 좀 더 편한 검색과 비교를 위해 코드 들여쓰기 및 변수, 메서드 네이밍 등 최대한 책과 동일하게 작성하려 했습니다.
* `shell script`를 실행하여 연습용 디렉토리(`exercise`)를 생성할 수 있습니다.


### Shell-script-descriptions
* ❓ 이 스크립트가 하는 일
  * `exercise` 패키지가 없으면, 생성하여 `example` 패키지 하위 파일을 모두 복사
* ⚠️ 주의
  * macOS Monterey 12.1에서만 테스트 됨
  * 저의 초급 수준으로 작성됐으므로 이미 작업 중이었다면 `git`으로 이력 관리 후 스크립트를 실행하는 것을 권장
    * 뭔가 잘못됐을 시 `git clean -fd`로 `Untracked files`를 제거
* 실행 방법
  * `./copy_directory_example_to_exercise.sh`
* 패키지명이 마음에 들지 않음
  * 패키지명은 오름차순을 고려하여 지었음. 변경을 원하는 경우 [이 부분](https://github.com/viiviii/java-refactoring-to-patterns/blob/be509bd69b3ba0a5bc9af3e7fb57f168dc05daee/copy_directory_example_to_exercise.sh#L11)
    을 수정


### Other-package-descriptions
* `completion` - 작성할 코드가 긴 경우 등의 이유로 완성된 코드가 있음
* `dummy` - 불필요한 라이브러리 추가를 피하기 위해 dummy 작성된 코드가 있음

---

> 오타 및 책과 다른 부분 등 언제든 제보주시면 감사하겠습니다.
