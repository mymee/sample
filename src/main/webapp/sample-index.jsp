<%--
**********************************************
* 기능 설명 : 메인 화면
* 기능 프로세스 : UIID-[###]
* 보안(ROLE) : ROLE_USER
**********************************************
--%>
<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>
<%@ taglib prefix="ui" uri="http://www.sbscontentshub.co.kr/ctl/ui"%>
<%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="Expires" content="-1" />
<title>Index</title>
<script type="text/javascript">
function test(msg){
	alert(msg);
};
</script>
</head>
<body>
<script type="text/javascript">
var x = new Date();
var timeZone = currentTimeZoneOffsetInHours = x.getTimezoneOffset()/60;
document.write('Timezone is: ' + timeZone);
</script>
	<h1>Welcome to Sample!!</h1>
	<a href="<%=request.getContextPath()%>/contact/showContacts.do">Web MVC
		Sample</a>
	<br />
	Spring MVC(CURD), myBatis, jQuery, Pagenation, Validation(Server/Client), Unit TestCase(Controller, Service) 등 
	<br/>
	<br/>
	<a href="<%=request.getContextPath()%>/ajaxSample.jsp">AJAX Sample</a>
	<br />
	jQuery AJAX를 이용한 RESTful 사용(GET/POST/PUT/DELETE) 예제(JSON)
	<br/>
	<p>
		Rest Sample URL<br /> <a href="<%=request.getContextPath()%>/books">http://localhost:8080<%=request.getContextPath()%>/books
		</a><br /> GET/POST/PUT/DELETE ajax 예제 참고<br />
	</p>
	<br/>
	<a href="<%=request.getContextPath()%>/uploadFile.do">File Upload Sample</a>
		FileUpload Sample(DevPia DEXTUpload 모듈 사용예정)
	<br/>
	<c:if test="${param['locale'] != null}">
	  <fmt:setLocale value="${param['locale']}" scope="session" />
	</c:if>
	<br/>
	<b>==============  참고 =======================================================</b>
	<br/>
	<H2>메세지 번들 사용 예</H2>
	
	<fmt:bundle basename="conf.messages.sample.sample" prefix="sample.">
		<fmt:message key="title.test" var="title"/>
		${title}</br>
	</fmt:bundle>

	<fmt:setBundle var="message" basename="conf.messages.sample.sample" />
	<fmt:message bundle="${message}" key="sample.title.test" var="title"/>
	${title}</br>
	<!-- Spring Bundle Message -->
	<spring:message code="sample.title.test" /><br/>
	<input type="text" value="<spring:message code='sample.title.test' />">
	<input type="button" value="click" onClick="test('<spring:message code='sample.title.test' />')"/>

    <H2>숫자형식 지정</H2>
    숫자 : <fmt:formatNumber value="123456.78" type="number"/> <br/>
    통화($) : <fmt:formatNumber value="7700000" type="currency" currencySymbol="$"/> <br/>
    통화() : <fmt:formatNumber value="7700000" type="currency" /> <br/>
    통화(\) : <fmt:formatNumber value="7700000" type="currency" currencySymbol="\\"/> <br/>
    패턴 : <fmt:formatNumber value="123456.789" pattern=".00"/> <br/>
 	퍼센트:<fmt:formatNumber value="0.99" pattern="#,###.00%"/><br/>
    
    <H2>날짜형식 지정</H2>
	<c:set var="currentDate" value="<%=new Date() %>"/>
    날짜 : <fmt:formatDate value="${currentDate}" type="date"/> <br/>
    시간 : <fmt:formatDate value="${currentDate}" type="time"/> <br/>
    날짜+시간+Timezone(GMT) : <fmt:formatDate value="${currentDate}" type="both" pattern="yyyy-MM-dd HH:mm:ss.S zz" timeZone="GMT"/> <br/>
    날짜+시간+Timezone(Asia/Seoul) : <fmt:formatDate value="${currentDate}" type="both" pattern="yyyy-MM-dd HH:mm:ss.S zz" timeZone="Asia/Seoul"/> <br/></br>
    날짜+시간 :  <fmt:formatDate value="${currentDate}" type="both" /> <br/></br>

	<br/>
	<b>==============  참고 =======================================================</b>
	<br/>
<pre>

<c:set var="clientLocale" value="${pageContext.request.locale}" />
<c:set var="clientLocales" value="${pageContext.request.locales}" />

<h2>Here is your Locale info...</h2>

Locale: <c:out value="${clientLocale.displayName}" />
Locale country: <c:out value="${clientLocale.displayCountry}" />
Locale language: <c:out value="${clientLocale.displayLanguage}" />

<h3>Lower priority locales...</h3>
<c:forEach var="loc" items="${clientLocales}" begin="1">
Locale: ${loc.displayName}
Locale country: ${loc.displayCountry}
Locale language: ${loc.displayLanguage}
<br />
</c:forEach>

■ local의 기본 정보 (IP, Name, Port)
Local IP : <%=request.getLocalAddr()%>
Local Name : <%=request.getLocalName()%>
Local Port : <%=request.getLocalPort()%>

■ 클라이언트의 정보
Remote IP : <%=request.getRemoteAddr()%>
Remote Host : <%=request.getRemoteHost() %>
Remote Port : <%=request.getRemotePort()%>

■ 서버 이름과 포트 (일반적으로 local 기본정보와 동일)
Server Name : <%=request.getServerName()%>
Server Port : <%=request.getServerPort()%>

■ 지역 정보 (대부분 한국을 의미하는 ko가 나옴)
Locale : <%=request.getLocale()%>

■ 사용하는 프로토콜 ("프로토콜/메이저버전.마이너버전" 의 형태)
Protocol : <%=request.getProtocol()%>

■ http, https, ftp와 같은 것을 의미
Scheme : <%=request.getScheme()%>

■ https와 같은 보안 채널의 사용 여부 (true/false 값으로 되어 있음)
Secure Channel : <%=request.isSecure()%><br>

■ 요청에 대한 URI, URL, 컨텍스트 경로, 서블릿 경로, GET/POST등의 메소드
Request's URI : <%=request.getRequestURI()%>
Request's URL : <%=request.getRequestURL()%>
Context Path : <%=request.getContextPath()%>
Servlet Path : <%=request.getServletPath()%>
Method : <%=request.getMethod()%>

■ 세션 ID에 대한 정보
Session ID : <%=request.getRequestedSessionId()%>
Session ID from Cookie : <%=request.isRequestedSessionIdFromCookie()%>
Session ID from URL : <%=request.isRequestedSessionIdFromURL()%>
Session ID is still valid : <%=request.isRequestedSessionIdValid()%>

■ Header 정보
<%
Enumeration eHeader = request.getHeaderNames();
while (eHeader.hasMoreElements()) {
    String hName = (String)eHeader.nextElement();
    String hValue = request.getHeader(hName);

    out.println(hName + " : " + hValue + "<br>");
}
%>

■ Request 객체를 통해서 쿠키 정보를 보는 방식
<%
Cookie cookies[] = request.getCookies();
if (cookies != null){
	for (int i=0; i < cookies.length; i++) {
	    String name = cookies[i].getName();
	    String value = cookies[i].getValue();
	
	    out.println(name + " : " + value + "<br>");
	}
}
%>

    /**
    * cookie 값을 설정하는 메소드.
    * @param HttpServletResponse response
    * @param String cookieName
    * @param String cookieVal!!ue
    */
    public void setCookie(HttpServletResponse response, String cookieName, String cookieVal!!ue) {
        int maxAge = (60 * 60 * 24 * 15); // 15day
        setCookie(response, cookieName, cookieVal!!ue, maxAge);
    }

    /**
    * cookie 값을 설정하는 메소드.
    * @param HttpServletResponse response
    * @param String cookieName
    * @param String cookieVal!!ue
    * @param int maxAge
    */
    public void setCookie(HttpServletResponse response, String cookieName, String cookieVal!!ue, int maxAge) {
        cookieVal!!ue = URLEncoder.encode(cookieVal!!ue);
        Cookie cookie = new Cookie(cookieName, cookieVal!!ue);
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }

    /**
    * cookie 값을 찾아서 리턴하는 메소드.
    * @param HttpServletRequest request
    * @param String cookieName
    * @return String
    */
    public String getCookie(HttpServletRequest request, String cookieName) {
        Cookie[] cookies = request.getCookies();
        String cookieVal!!ue = null;
        for (int i = 0; i < cookies.length; i++) {
            if (cookieName.equals(cookies[i].getName())) {
                cookieVal!!ue = URLDecoder.decode(cookies[i].getValue());
                break;
            }
        }
        return cookieVal!!ue;
    }

■ HTML 폼을 통해 넘어온 데이터를 받는 부분
<%
Enumeration eParam = request.getParameterNames();
while (eParam.hasMoreElements()) {
    String pName = (String)eParam.nextElement();
    String pValue = request.getParameter(pName);

    out.println(pName + " : " + pValue + "<br>");
}
%>

■ 미리 설정한 attribute를 가져오는 부분
<%
Enumeration eAttr = request.getAttributeNames();
while (eAttr.hasMoreElements()) {
    String aName = (String)eAttr.nextElement();
    String aValue = request.getHeader(aName);

    out.println(aName + " : " + aValue + "<br>");
}
%>

request.XXX
=============================================================
// 클라이언트 정보 및 서버정보 읽기
=============================================================
String  getRemoteAddr()            웹서버에 연결한 클라이언트의 IP 주소를 가져온다.
long    getContentLength()         클라이언트가 전송한 요청 정보의 길이를 구해온다.
String  getCharacterEncoding()     클라이언트가 요청 정보를 전송할 때 사용한 캐릭터의  인코딩을 구해온다.
String  getContentType()           클라이언트가 요청 정보를 전송할 때 사용한 컨텐츠의 타입을 구해온다.
String  getProtocol()              클라이언트가 요청한 프로토콜을 구한다.
String  getMethod()                웹 브라우저가 정보를 전송할 때 사용한 방식을 구한다.
String  getRequestURI()            웹 브라우저가 요청한 URL에서 경로를 구한다.
String  getContextPath()           JSP페이지가 속한 웹 어플리케이션의 콘텍스트 경로를구한다.
String  getServerName()            연결할 때 사용한 서버 이름을 구한다.
String  getServerPort()            서버가 실행 중인 포트 번호를 구한다.
 
=============================================================
//HTML폼과 요청파라미터 처리
=============================================================
String  getParameter(String name)              이름이 name인 파라미터의 값을 구한다(Request("name") 과 동일)
String[]  getParameterValues(String name)      이름이 name인 모든 파라미터의 값을 배열로 가져온다.
java.util.Enumeration  getParameterNames()     웹브라우저가 전송한  파라미터의 이름을 구한다.
java.util.Map  getParameterMap()               웹브라우저가 전송한 파라미터의 맵을 구한다.

ex> name파람 = request.getParameter("name")
      Enumeration enum = request.getParameterNames();
         while(enum.hasMoreElements)
              String name = (String)enum.nextElement();
=============================================================
//요청 헤더 정보의 처리
=============================================================
String  getHeader(String name)                    지정한 이름의 헤더값을 구한다.
java.util.Enumeration  getHeasers(String name)    지정한 이름의 헤더 목록을 구한다.
java.util.Enumeration  getHeaderName()            모든 헤더의 이름을 구한다.
int  getIntHeader(String name)                    지정한 헤더의 값을 정수값으로 읽어온다.
long getDateHeader(String name)                   지정한 헤더의 값을 시간값으로읽어온다 (1970년1월1일 이후로 흘러간 1/1000초 단위로 읽어온다.)

ex> Enumeration enum = request.getHeaderNames();
        while(enum.hasMoreElements()){
            String headerName = (String)enum.nextElement();
            String headerValue = request.getHeader(headerName);
        }
 
=============================================================
//값 설정하기(Attribute)
=============================================================
void  setAttribute(String name, Object values)   이름이 name인 속성의 값을 values로 저장한다.
Object getAttribute(String name)                 이름이 name인 속성의 값을 구한다.
void removeAttribute(String name)                이름이 name인 속성을 삭제한다.
java.util.Enumeration getAttributeNames()        속성의 이름 목록을 구한다.

## 주의 : setAttribute 에서 값이 Object이기 때문에 int, double과 같은 기본 데이터 타입은 속성값에 할당 할 수 없다. 이유는 Object가 아니기 때문이다. 이 경우엔 레퍼 클래스를 사용해야 한다.
      Integer intValue = new Integer(100);
      request.setAttribute("radio", intValue);
      ...
      Integer intValue = (Integer)request.getAttribute("radio");
      int value = intValue.intValue();
</pre>

	<b>사용 가능한 시간대 문자열 확인 소스</b>
<c:forEach var="id" items="<%= java.util.TimeZone.getAvailableIDs() %>">
${id}<br/>
</c:forEach>

</body>
</html>