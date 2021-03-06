# spring-login

## 쿠키

- 쿠키는 임의로 변경할 수 있다
- 쿠키는 탈취가 쉽게 가능하다
- 쿠키 보안 문제로 인해 세션을 사용하게된다 (쿠키는 사용자의 중요한 정보는 보관 X)

## 세션

- 서버에서 사용자의 중요한 데이터를 가지고 임의의 값으로 쿠키값을 제공한다
- 세션은 최소한의 데이터만 보관해야 한다 (보관용량 * 사용자수 만큼 메모리 사용량이 증가하기 때문, 실무에서는 사용자 id 정도만 보관)
- 세션의 시간을 너무 길게 가져가면 메모리 사용이 누적될 수 있으므로 적절한 시간을 선택해야 함

## 필터

```
HTTP 요청 -> WAS -> 필터 -> 서블릿 -> 컨트롤러
```

- 서블릿 필터는 공통 관심 사항을 효과적으로 해결할 수 있다
- `chain.doFilter` 호출되어야 다음 서블릿 요청을 하게됨
- 서블릿 필터를 잘 사용하면 추후 정책 변경에 닫혀있는 구조가 되었다


## 스프링 인터셉터

```
HTTP 요청 -> WAS -> 필터 -> 서블릿 -> 스프링 인터셉터 -> 컨트롤러
```

- 스프링 인터셉터도 서블릿 필터와 같이 웹과 관련된 공통 관심 사항을 효과적으로 해결할 수 있다 (더 강력한 기능을 제공)
- 스프링 인터셉터는 스프링 MVC가 제공하는 기능이기 때문에 디스패처 서블릿 이후 등장하게되었다 (디스패처 서블릿이 시작)
- 서블릿 필터보다 편리하고 정교한 기능을 제공 (특별한 경우가 아니면 스프링 인터셉터를 사용함)



![servlet](src/main/resources/dispatcherServlet.png)
