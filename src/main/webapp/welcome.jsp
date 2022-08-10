<%--
  Created by IntelliJ IDEA.
  User: LeeGaki
  Date: 2021/12/19
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="yz-login.jsp"%>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        @import url('https://fonts.googleapis.com/css?family=Lato');
        *,
        *::after,
        *::before {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            min-height: 100vh;
            padding: 40px;
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            align-items: center;
            font-family: "Lato", "Segoe Ui", -apple-system, BlinkMacSystemFont, sans-serif;
        }

        .flip-card-container {
            --hue: 150;
            --primary: hsl(var(--hue), 50%, 50%);
            --white-1: hsl(0, 0%, 90%);
            --white-2: hsl(0, 0%, 80%);
            --dark: hsl(var(--hue), 25%, 10%);
            --grey: hsl(0, 0%, 50%);

            width: 310px;
            height: 500px;
            margin: 40px;
            perspective: 1000px;
        }

        .flip-card {
            width: inherit;
            height: inherit;

            position: relative;
            transform-style: preserve-3d;
            transition: .6s .1s;
        }

        /* hover and focus-within states */
        .flip-card-container:hover .flip-card,
        .flip-card-container:focus-within .flip-card {
            transform: rotateY(180deg);
        }

        .card-front,
        .card-back {
            width: 100%;
            height: 100%;
            border-radius: 24px;

            background: var(--dark);
            position: absolute;
            top: 0;
            left: 0;
            overflow: hidden;

            backface-visibility: hidden;

            display: flex;
            justify-content: center;
            align-items: center;
        }

        /* .card-front */
        .card-front {
            transform: rotateY(0deg);
            z-index: 2;
        }

        /* .card-back */
        .card-back {
            transform: rotateY(180deg);
            z-index: 1;
        }

        /* figure */
        figure {
            z-index: -1;
        }

        /* figure, .img-bg */
        figure,
        .img-bg {
            position: absolute;
            top: 0;
            left: 0;

            width: 100%;
            height: 100%;
        }

        /* img */
        img {
            height: 100%;
            border-radius: 24px;
        }

        /* figcaption */
        figcaption {
            display: block;

            width: auto;
            margin-top: 12%;
            padding: 8px 22px;

            font-weight: bold;
            line-height: 1.6;
            letter-spacing: 2px;
            word-spacing: 6px;
            text-align: right;

            position: absolute;
            top: 0;
            right: 12px;

            color: var(--white-1);
            background: hsla(var(--hue), 25%, 10%, .5);
        }

        /* .img-bg */
        .img-bg {
            background: hsla(var(--hue), 25%, 10%, .5);
        }

        .card-front .img-bg {
            clip-path: polygon(0 20%, 100% 40%, 100% 100%, 0 100%);
        }

        .card-front .img-bg::before {
            content: "";

            position: absolute;
            top: 34%;
            left: 50%;
            transform: translate(-50%, -50%) rotate(18deg);

            width: 100%;
            height: 6px;
            border: 1px solid var(--primary);
            border-left-color: transparent;
            border-right-color: transparent;

            transition: .1s;
        }

        .card-back .img-bg {
            clip-path: polygon(0 0, 100% 0, 100% 80%, 0 60%);
        }

        /* hover state */
        .flip-card-container:hover .card-front .img-bg::before {
            width: 6px;
            border-left-color: var(--primary);
            border-right-color: var(--primary);
        }

        /* ul */
        ul {
            padding-top: 50%;
            margin: 0 auto;
            width: 70%;
            height: 100%;

            list-style: none;
            color: var(--white-1);

            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
        }

        /* li */
        li {
            width: 100%;
            margin-top: 12px;
            padding-bottom: 12px;

            font-size: 14px;
            text-align: center;

            position: relative;
        }

        li:nth-child(2n) {
            color: var(--white-2);
        }

        li:not(:last-child)::after {
            content: "";

            position: absolute;
            bottom: 0;
            left: 0;

            width: 100%;
            height: 1px;

            background: currentColor;
            opacity: .2;
        }

        /* button */
        button {
            font-family: inherit;
            font-weight: bold;
            color: var(--white-1);

            letter-spacing: 2px;

            padding: 9px 20px;
            border: 1px solid var(--grey);
            border-radius: 1000px;
            background: transparent;
            transition: .3s;

            cursor: pointer;
        }

        button:hover,
        button:focus {
            color: var(--primary);
            background: hsla(var(--hue), 25%, 10%, .2);
            border-color: currentColor;
        }

        button:active {
            transform: translate(2px);
        }

        /* .design-container */
        .design-container {
            --tr: 90;
            --op: .5;

            width: 100%;
            height: 100%;

            background: transparent;
            position: absolute;
            top: 0;
            left: 0;

            pointer-events: none;
        }

        /* .design */
        .design {
            display: block;

            background: var(--grey);
            position: absolute;

            opacity: var(--op);
            transition: .3s;
        }

        .design--1,
        .design--2,
        .design--3,
        .design--4 {
            width: 1px;
            height: 100%;
        }

        .design--1,
        .design--2 {
            top: 0;
            transform: translateY(calc((var(--tr) - (var(--tr) * 2)) * 1%))
        }

        .design--1 {
            left: 20%;
        }

        .design--2 {
            left: 80%;
        }

        .design--3,
        .design--4 {
            bottom: 0;
            transform: translateY(calc((var(--tr) + (var(--tr) - var(--tr))) * 1%))
        }

        .design--3 {
            left: 24%;
        }

        .design--4 {
            left: 76%;
        }

        .design--5,
        .design--6,
        .design--7,
        .design--8 {
            width: 100%;
            height: 1px;
        }

        .design--5,
        .design--6 {
            left: 0;
            transform: translateX(calc((var(--tr) - (var(--tr) * 2)) * 1%));
        }

        .design--5 {
            top: 41%;
        }

        .design--6 {
            top: 59%;
        }

        .design--7,
        .design--8 {
            right: 0;
            transform: translateX(calc((var(--tr) + (var(--tr) - var(--tr))) * 1%))
        }

        .design--7 {
            top: 44%;
        }

        .design--8 {
            top: 56%;
        }

        /* states */
        button:hover+.design-container,
        button:active+.design-container,
        button:focus+.design-container {
            --tr: 20;
            --op: .7;
        }

        .abs-site-link {
            position: fixed;
            bottom: 20px;
            left: 20px;
            color: hsla(0, 0%, 100%, .6);
            font-size: 16px;
            font-family: 'Segoe UI', -apple-system, BlinkMacSystemFont, sans-serif;
        }
    </style>
</head>

<body>
<!-- flip-card-container -->
<div class="flip-card-container" style="--hue: 220">
    <div class="flip-card">
        <blockquote class="layui-elem-quote" style="font-size: 15px;color: #007DDB">欢迎使用大学生教学管理系统</blockquote>
        <div class="card-front">
            <figure>
                <div class="img-bg"></div>
                <img
                        src="https://pic.rmb.bdstatic.com/bjh/down/31f0481be93531da0050992e5e1d00ca.jpeg@wm_2,t_55m+5a625Y+3L+aWsOagoemVv+S8oOWqkg==,fc_ffffff,ff_U2ltSGVp,sz_19,x_12,y_12"
                        alt="Brohm Lake">
                <figcaption>Chinese</figcaption>
            </figure>

            <ul>
                <li>语文的教学</li>
            </ul>
        </div>

        <div class="card-back">
            <figure>
                <div class="img-bg"></div>
                <img
                        src="https://pic.rmb.bdstatic.com/bjh/down/31f0481be93531da0050992e5e1d00ca.jpeg@wm_2,t_55m+5a625Y+3L+aWsOagoemVv+S8oOWqkg==,fc_ffffff,ff_U2ltSGVp,sz_19,x_12,y_12"
                        alt="Brohm Lake">
            </figure>

            <button>语文Book</button>

            <div class="design-container">
                <span class="design design--1"></span>
                <span class="design design--2"></span>
                <span class="design design--3"></span>
                <span class="design design--4"></span>
                <span class="design design--5"></span>
                <span class="design design--6"></span>
                <span class="design design--7"></span>
                <span class="design design--8"></span>
            </div>
        </div>

    </div>
</div>
<!-- /flip-card-container -->

<!-- flip-card-container -->
<div class="flip-card-container" style="--hue: 170">
    <div class="flip-card">

        <div class="card-front">
            <figure>
                <div class="img-bg"></div>
                <img
                        src="https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.alicdn.com%2Fbao%2Fuploaded%2Fi4%2F2561518841%2FO1CN01rnxUW82FBECg6182F_%21%212-item_pic.png&refer=http%3A%2F%2Fimg.alicdn.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1657420068&t=44be42624cdc7a5fe2563955d71f6c05"
                        alt="Image 2">
                <figcaption>Mathematics</figcaption>
            </figure>

            <ul>
                <li>数学的教学</li>
            </ul>
        </div>

        <div class="card-back">
            <figure>
                <div class="img-bg"></div>
                <img
                        src="https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.alicdn.com%2Fbao%2Fuploaded%2Fi4%2F2561518841%2FO1CN01rnxUW82FBECg6182F_%21%212-item_pic.png&refer=http%3A%2F%2Fimg.alicdn.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1657420068&t=44be42624cdc7a5fe2563955d71f6c05"
                        alt="image-2">
            </figure>

            <button>数学Book</button>

            <div class="design-container">
                <span class="design design--1"></span>
                <span class="design design--2"></span>
                <span class="design design--3"></span>
                <span class="design design--4"></span>
                <span class="design design--5"></span>
                <span class="design design--6"></span>
                <span class="design design--7"></span>
                <span class="design design--8"></span>
            </div>
        </div>

    </div>
</div>
<!-- /flip-card-container -->

<!-- flip-card-container -->
<div class="flip-card-container" style="--hue: 350">
    <div class="flip-card">

        <div class="card-front">
            <figure>
                <div class="img-bg"></div>
                <img
                        src="https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fc-ssl.duitang.com%2Fuploads%2Fitem%2F202006%2F23%2F20200623174940_ybbcr.jpg&refer=http%3A%2F%2Fc-ssl.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1657420107&t=b80ca9725f96aed90a2b687dbdeb9e96"
                        alt="Brohm Lake">
                <figcaption>English</figcaption>
            </figure>

            <ul>
                <li>英语的教学</li>
            </ul>
        </div>

        <div class="card-back">
            <!-- only if the image is necessary -->
            <figure>
                <div class="img-bg"></div>
                <img
                        src="https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fc-ssl.duitang.com%2Fuploads%2Fitem%2F202006%2F23%2F20200623174940_ybbcr.jpg&refer=http%3A%2F%2Fc-ssl.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1657420107&t=b80ca9725f96aed90a2b687dbdeb9e96"
                        alt="Brohm Lake">
            </figure>

            <button>英语Book</button>

            <!-- can add svg here and remove these eight spans -->
            <div class="design-container">
                <span class="design design--1"></span>
                <span class="design design--2"></span>
                <span class="design design--3"></span>
                <span class="design design--4"></span>
                <span class="design design--5"></span>
                <span class="design design--6"></span>
                <span class="design design--7"></span>
                <span class="design design--8"></span>
            </div>
        </div>

    </div>
</div>
</body>
</html>
