<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>CREP Layout</title>
<style>
  /* 기본 리셋 */
  * {
    box-sizing: border-box;
    margin: 0;
    padding: 0;
  }

  html, body {
    height: 100%;
  }

  body {
    font-family: 'Arimo','Noto Sans KR',sans-serif;
    background-color: #f9fafb;
    color: #111827;
  }

  /* ====== 레이아웃 구조 ====== */
  .layout {
    display: grid;
    grid-template-rows: 72px 1fr 80px;  /* 헤더, 본문, 푸터 (푸터 고정 높이 80px) */
    grid-template-columns: 260px 1fr;   /* 사이드바 고정 너비 260px */
    grid-template-areas:
      "header header"
      "sidebar main"
      "footer footer";
    min-height: 100vh;
  }

  header.layout-header {
    grid-area: header;
    background: #fff;
    position: sticky;
    top: 0;
    z-index: 100;
    border-bottom: 1px solid #e5e7eb;
  }

  aside.layout-sidebar {
    grid-area: sidebar;
    background: #fff;
    border-right: 1px solid #e5e7eb;
    height: calc(100vh - 72px - 80px); /* 헤더/푸터를 제외한 전체 높이 */
    position: sticky;
    top: 72px; /* 헤더 아래에 고정 */
    overflow-y: auto;
  }

  main.layout-main {
    grid-area: main;
    padding: 24px;
    overflow-y: auto;
    background: #f9fafb;
  }

  footer.layout-footer {
    grid-area: footer;
    background: #fff;
    border-top: 1px solid #e5e7eb;
    height: 80px; /* 고정 높이 */
    display: flex;
    align-items: center;
    justify-content: center;
    font-size: 14px;
    color: #4a5565;
  }

  /* ====== 반응형 (작은 화면일 때) ====== */
  @media (max-width: 960px) {
    .layout {
      grid-template-columns: 1fr;  /* 사이드바를 숨기고 한 열로 */
      grid-template-rows: 72px 1fr 80px;
      grid-template-areas:
        "header"
        "main"
        "footer";
    }
    aside.layout-sidebar {
      display: none;
    }
  }

  /* ====== 미디어 넘침 방지 ====== */
  img, video, iframe {
    max-width: 100%;
    height: auto;
  }
</style>
</head>
<body>

  <div class="layout">
    <!-- Header -->
    <header class="layout-header">
      <jsp:include page="/views/components/header.jsp" />
    </header>

    <!-- Sidebar -->
    <aside class="layout-sidebar">
      <jsp:include page="/views/components/sidebar.jsp" />
    </aside>

    <!-- Main Content -->
    <main class="layout-main">
      <h1>대시보드 본문 영역</h1>
      <p>이곳은 페이지의 메인 콘텐츠가 들어가는 영역입니다.</p>
    </main>

    <!-- Footer -->
    <footer class="layout-footer">
      <jsp:include page="/views/components/footer.jsp" />
    </footer>
  </div>

</body>
</html>
