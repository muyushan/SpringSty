<%--
  Created by IntelliJ IDEA.
  User: muyushan
  Date: 2018/4/5
  Time: 下午8:52
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style type="text/css">
        .episode{
            display: block;
            float: left;
            width: 60px;
            height: 20px;
            background-color: beige;
             padding: 10px 5px;
            margin: 5px 5px;
            text-align: center;
            cursor: hand;
        }

        .spiltline{
            clear: left;
        }
        .currentepisode{
            color: red;
            background-color: cornflowerblue;
        }
    </style>
    <script src="js/jquery-3.3.1.min.js"></script>
    <link href="css/video-js.css" rel="stylesheet" type="text/css">
    <script src="js/video.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            for(i=1;i<78;i++){
                var num=i;
                if(i<10){
                    num="0"+num;
                }
                $("#episodeselector").append("<a class='episode'>"+num+"</a>");
                    if(i%10==0){
                        $("#episodeselector").append("<div class='spiltline'></div>");
                    }
            }
            
            $(".episode").click(function(){
                var num=$(this).text();
                $("video").attr("src","moves/EP"+num+".mp4");
                $(".episode").removeClass("currentepisode");
                $(this).addClass("currentepisode");
                setCookie("episode",num);
            });

            var cookieEpisode=getCookie("episode");

            if(cookieEpisode!=""){
                $("video").attr("src","moves/EP"+cookieEpisode+".mp4");
                $(".episode").each(function () {

                    if($(this).text()==cookieEpisode){
                        $(this).addClass("currentepisode");
                    }
                })
            }else{

            }

            var myPlayer = videojs('example_video_1');
            videojs("example_video_1").ready(function(){
                var myPlayer = this;
                myPlayer.play();
            });
        });


        function setCookie(name,value)
        {
            var Days = 30;
            var exp = new Date();
            exp.setTime(exp.getTime() + Days*24*60*60*1000);
            document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();
        }
        function getCookie(name)
        {
            var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
            if(arr=document.cookie.match(reg))
                return unescape(arr[2]);
            else
                return "";
        }




    </script>
    <title>白鹿原</title>
</head>
<body>
<div style="width: 800px; height: 400px;">
    <video id="example_video_1" class="video-js vjs-default-skin vjs-big-play-centered" controls preload="auto" src="" width="640" height="400"
           data-setup="{}">
    </video>
</div>
<div id="episodeselector" style="margin-left: 250px; margin-top: 100px; padding-left: 10px; padding-right: 10px;">


</div>


</body>
</html>
