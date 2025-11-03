<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CREP</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Arimo', 'Noto Sans KR', sans-serif;
            background: white;
        }

        .app-container {
            width: 100%;
            height: 72px;
            position: relative;
            background: white;
            border-bottom: 1px solid #e5e7eb;
            box-shadow: 0px 1px 3px 0px rgba(0,0,0,0.1), 0px 1px 2px -1px rgba(0,0,0,0.1);
        }

        .header-content {
            width: 100%;
            height: 72px;
            position: relative;
        }

        /* Left section - Menu & Logo */
        .left-section {
            position: absolute;
            left: 24px;
            top: 12px;
            display: flex;
            align-items: center;
            gap: 16px;
            height: 48px;
        }

        .menu-button {
            width: 36px;
            height: 36px;
            border-radius: 8px;
            border: none;
            background: transparent;
            cursor: pointer;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .menu-button:hover {
            background: #f3f4f6;
            transform: scale(0.95);
           
        }

        .menu-icon {
            width: 25px;
            height: 20px;
        }

        .logo-container {
            display: flex;
            align-items: center;
            gap: 12px;
        }

        .logo-image {
            width: 48px;
            height: 48px;
            border-radius: 4px;
        }

        .logo-text {
            font-size: 30px;
            font-weight: bold;
            color: #f54900;
            line-height: 36px;
        }

        /* Center section - Search */
        .search-container {
            position: absolute;
            left: 50%;
            transform: translateX(-50%);
            top: 18px;
            width: 448px;
            height: 36px;
        }

        .search-wrapper {
            position: relative;
            width: 100%;
            height: 100%;
        }

        .search-input {
            width: 100%;
            height: 100%;
            padding: 8px 16px 8px 40px;
            background: #f3f3f5;
            border: 1px solid #d1d5dc;
            border-radius: 8px;
            font-size: 14px;
            color: #717182;
            outline: none;
        }

        .search-input::placeholder {
            color: #717182;
        }

        .search-input:focus {
            border-color: #9ca3af;
        }

        .search-icon {
            position: absolute;
            left: 12px;
            top: 10px;
            width: 16px;
            height: 16px;
        }

        /* Right section - Actions */
        .right-section {
            position: absolute;
            right: 24px;
            top: 16px;
            display: flex;
            align-items: center;
            gap: 12px;
            height: 40px;
        }

        .icon-button {
            width: 36px;
            height: 36px;
            border-radius: 8px;
            border: none;
            background: transparent;
            cursor: pointer;
            display: flex;
            align-items: center;
            justify-content: center;
            position: relative;
        }

        .icon-button:hover {
            background: #f3f4f6;
            transform: scale(0.95);
        }

        .button-icon {
            width: 20px;
            height: 20px;
        }

        .notification-badge {
            position: absolute;
            top: 4px;
            right: 4px;
            width: 8px;
            height: 8px;
            background: #fb2c36;
            border-radius: 50%;
        }

        .avatar-button {
            width: 40px;
            height: 40px;
            border-radius: 50%;
            border: 1px solid #ffd6a7;
            background: transparent;
            cursor: pointer;
            padding: 1px;
            overflow: hidden;
        }

        .avatar-button:hover {
            opacity: 0.8;
            transform: scale(0.95);
        }

        .avatar-image {
            width: 100%;
            height: 100%;
            border-radius: 50%;
            object-fit: cover;
        }
    </style>
</head>
<body>
    <div class="app-container">
        <div class="header-content">
            <!-- Left Section: Menu & Logo -->
            <div class="left-section">
                <button class="menu-button" aria-label="메뉴">
                    <img class="menu-icon" src="${cpath}/views/images/sidebar_icon.png" alt="메뉴">
                </button>
                <div class="logo-container">
                    <img class="logo-image" src="${cpath}/views/images/logo.png" alt="로고">
                    <div class="logo-text">CREP</div>
                </div>
            </div>

            <!-- Center Section: Search -->
            <div class="search-container">
                <div class="search-wrapper">
                    <input type="text" class="search-input" placeholder="검색...">
                    <img class="search-icon" src="${cpath}/views/images/search_icon.png" alt="검색창">
                </div>
            </div>

            <!-- Right Section: Actions -->
            <div class="right-section">
                <button class="icon-button" aria-label="테마 전환">
                    <img class="button-icon" src="${cpath}/views/images/moon_icon.png" alt="다크모드">
                </button>
                <button class="icon-button" aria-label="알림">
                   <img class="button-icon" src="${cpath}/views/images/bell_icon.png" alt="알림">
                    <span class="notification-badge"></span>
                </button>
                <button class="avatar-button" aria-label="프로필">
  					<img class="avatar-image" src="${cpath}/views/images/avatar_image.png" alt="프로필">
				</button>
            </div>
        </div>
    </div>

    <script>
        // Add interactivity if needed
        document.querySelector('.menu-button').addEventListener('click', function() {
            alert('메뉴 클릭됨');
        });

        document.querySelector('.search-input').addEventListener('input', function(e) {
            console.log('검색어:', e.target.value);
        });
    </script>
</body>
</html>
