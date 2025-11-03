<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Sidebar</title>
  <style>
    body {
      margin: 0;
      font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', 'Roboto', 'Helvetica Neue', Arial, sans-serif;
    }
    
    .sidebar {
      background-color: white;
      position: relative;
      width: 254.878px;
      min-height: 100vh;
    }
    
    .sidebar-border {
      position: absolute;
      border-right: 1.111px solid #e5e7eb;
      top: 0;
      left: 0;
      right: 0;
      bottom: 0;
      pointer-events: none;
    }
    
    .sidebar-inner {
      width: 100%;
      height: 100%;
    }
    
    .sidebar-content {
      box-sizing: border-box;
      display: flex;
      flex-direction: column;
      align-items: flex-start;
      padding-right: 1.111px;
      width: 100%;
      height: 100%;
    }
    
    .container {
      position: relative;
      flex-shrink: 0;
      width: 100%;
    }
    
    .navigation {
      position: absolute;
      left: 0;
      top: 15.99px;
      width: 254.878px;
    }
    
    .menu-header {
      height: 39.983px;
      left: 12px;
      display: flex;
      align-items: center;
      margin-top: 10px;
    }
    
    .menu-title {
      font-weight: 400;
      line-height: 24px;
      padding-left: 12px;
      color: #f54900;
      font-size: 16px;
      white-space: nowrap;
      margin: 0;
    }
    
    .button {
      position: relative;
      box-sizing: border-box;
      display: flex;
      gap: 12px;
      height: 44px;
      align-items: center;
      left: 12px;
      padding: 0 12px;
      border-radius: 10px;
      width: 230.885px;
      cursor: pointer;
      transition: background-color 0.2s ease, transform 0.1s ease;
    }
    
    /* hover 효과 */
    .button:hover {
      background-color: #ffedd4;
    }
    .button:active {
      transform: scale(0.98);
    }

    .icon {
      width: 20px;
      height: 20px;
      display: flex;
      align-items: center;
      justify-content: center;
    }
    
    .icon img {
      width: 100%;
      height: 100%;
      object-fit: contain;
      transition: filter 0.2s ease;
      filter: brightness(0) saturate(100%) invert(25%) sepia(9%) saturate(1069%) hue-rotate(177deg) brightness(93%) contrast(89%);
    }

    /* hover 시 아이콘 색상 오렌지 */
    .button:hover .icon img {
      filter: brightness(0) saturate(100%) invert(35%) sepia(93%) saturate(2447%) hue-rotate(6deg) brightness(101%) contrast(98%);
    }

    .button-text {
      font-weight: 400;
      line-height: 24px;
      font-size: 16px;
      white-space: nowrap;
      margin: 0;
      color: #364153; /* 기본 색 (모두 동일) */
      transition: color 0.2s ease;
    }

    /* hover 시 텍스트 색상 오렌지 */
    .button:hover .button-text {
      color: #f54900;
    }
    
    .footer-container {
      position: absolute;
      box-sizing: border-box;
      display: flex;
      flex-direction: column;
      height: 73px;
      align-items: flex-start;
      left: 0;
      padding: 13px 12px 0 12px;
      bottom: 0;
      width: 254.878px;
    }
    
    .footer-border {
      position: absolute;
      border-top: 1.111px solid #e5e7eb;
      top: 0;
      left: 0;
      right: 0;
      bottom: 0;
      pointer-events: none;
    }
    
    .version-container {
      background-color: #f3f4f6;
      height: 48px;
      position: relative;
      border-radius: 10px;
      width: 100%;
      display: flex;
      align-items: center;
      padding-left: 12px;
      box-sizing: border-box;
      transition: background-color 0.2s ease;
    }
    
    .version-container:hover {
      background-color: #e5e7eb;
    }
    
    .version-content {
      display: flex;
      flex-direction: column;
      gap: 2px;
    }
    
    .paragraph-text {
      font-weight: 400;
      line-height: 16px;
      font-size: 12px;
      white-space: nowrap;
      margin: 0;
    }
    
    .paragraph-text-1 {
      color: #4a5565;
    }
    
    .paragraph-text-2 {
      color: #6a7282;
    }
  </style>
</head>
<body>
  <div class="sidebar" data-name="Sidebar">
    <div aria-hidden="true" class="sidebar-border"></div>
    <div class="sidebar-inner">
      <div class="sidebar-content">
        <div class="container" data-name="Container">
          
          <!-- Navigation -->
          <div class="navigation" data-name="Navigation">
            
            <!-- 메뉴 헤더 -->
            <div class="menu-header">
              <p class="menu-title">메뉴</p>
            </div>
            
            <!-- 버튼 목록 -->
            <div class="button button-1">
              <div class="icon"><img src="${cpath}/views/images/dashboard_icon.png" alt="대시보드"></div>
              <span class="button-text">대시보드</span>
            </div>

            <div class="button button-2">
              <div class="icon">
                <img src="${cpath}/views/images/calendar_icon.png" alt="일정 관리">
              </div>
              <span class="button-text">일정 관리</span>
            </div>

            <div class="button button-3">
              <div class="icon">
                <img src="${cpath}/views/images/video_icon.png" alt="콘텐츠 관리">
              </div>
              <span class="button-text">콘텐츠 관리</span>
            </div>

            <div class="button button-4">
              <div class="icon">
                <img src="${cpath}/views/images/report_icon.png" alt="재무 관리">
              </div>
              <span class="button-text">재무 관리</span>
            </div>

            <div class="button button-5">
              <div class="icon">
                <img src="${cpath}/views/images/handshake.png" alt="협찬 계약">
              </div>
              <span class="button-text">협찬 계약</span>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
</html>
