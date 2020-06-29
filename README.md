# CMS-Android

CMS(Club Management Service)는 학교 내에서 동아리 관리를 편리하게 만들고자 하는 목적으로 시작된 프로젝트입니다.

아직 프로젝트 초기 개발 단계이기 때문에 미완성된 부분이나 좋지 않은 로직이 존재할 수 있고, 새로운 기술들이 적용될 수 있습니다.

*가능하다면 프로젝트에 **Dagger-Hilt**가 적용될 예정입니다.*

## Team 

[홍성하](https://github.com/KRMKGOLD)

## Git

**Branch**

1. master - feature 별로 나눈 branch들이 병합된다.
2. feature - 각 기능단위로 나누고, 네이밍은 git globoard issue number로 설정한다.

**Commit Message**

1. [Add] - 기능 또는 파일을 추가하는 경우에 사용 
2. [Modify] - 기능 또는 파일을 수정하는 경우에 사용
3. [Remove] - 기능 또는 파일을 제거하는데 사용
4. [Fix] - 예상치 못한 오류 또는 Hotfix를 수정한 경우에 사용
5. [Refactor] - Code Review 또는 리팩토링을 거친 경우에 사용

```
Glo-Issue-Number [Header] Title
```

## Pattern

- AAC ViewModel을 이용한 MVVM 패턴을 사용하여 개발했습니다.

**Structure**

![Untitled Diagram (1)](https://user-images.githubusercontent.com/37148833/85989607-b7e7c000-ba2b-11ea-8bbc-b31f3c2f3e2a.png)

## Tech & Library

- Android Jetpack
  - Foundation
    - Android KTX
    - AppCompat
  - Architecture
    - DataBinding
    - LifeCycle
    - LiveData
    - ViewModel
    - Navigation
  - UI
    - RecyclerView
    - Navigation Drawer
- ReactiveX
  - RxJava2
  - RxAndroid
- Networking
  - Retrofit & Gson
  - OkHttp
- Firebase
  - Firebase Cloud Messaging(FCM)
- *DI(Dependency Injection)*
  - *Dagger-Hilt*
- Image
  - Glide
