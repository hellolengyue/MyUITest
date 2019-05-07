package com.example.myuitest.titlelist;

import java.util.List;

/**
 * @author hel
 * @date 2018/12/26
 * 文件 ChatLive
 * 描述
 */

public class CountryDetailBean {


    /**
     * errcode : 0
     * msg : 成功
     * result : [{"img":"http://picbothlive2.oss-cn-hangzhou.aliyuncs.com/country/Russia.png?x-oss-process=style/imageSmall","name":"Russia","id":2,"anchorList":[{"income":40,"channelTopic":null,"country":null,"gender":1,"city":null,"appName":"bothlive","channel":"cptest100044","channelImage":"http://picbothlive1.oss-cn-hangzhou.aliyuncs.com/icon/third/56B022846A764FF6B821DE962DE99DEC.png?x-oss-process=style/imageMiddle","onlineUsers":38,"liveLevel":1,"videoFlag":2,"anchorrich":null,"userId":100005283,"pushDomain":"wspullyt.xxshow.com","hisViewers":0,"channelAddr":null,"vip":false,"svip":false,"recordPlayUrl":null,"username":"蔡彦飞"}]},{"img":"http://picbothlive2.oss-cn-hangzhou.aliyuncs.com/country/USA.png?x-oss-process=style/imageSmall","name":"U.S.A","id":8,"anchorList":[{"income":82394,"channelTopic":null,"country":null,"gender":2,"city":null,"appName":"bothlive","channel":"cptest100042","channelImage":"http://picbothlive1.oss-cn-hangzhou.aliyuncs.com/aa.jpg?x-oss-process=style/imageMiddle","onlineUsers":53,"liveLevel":49,"videoFlag":2,"anchorrich":102909,"userId":100000114,"pushDomain":"wspullyt.xxshow.com","hisViewers":0,"channelAddr":null,"vip":true,"svip":true,"recordPlayUrl":null,"username":"Asker"},{"income":160,"channelTopic":null,"country":null,"gender":1,"city":null,"appName":"bothlive","channel":"cptest100045","channelImage":"http://picbothlive2.oss-cn-hangzhou.aliyuncs.com/icon/100000116/58C4FECAE53244EB936934404C18E393.png?x-oss-process=style/imageMiddle","onlineUsers":0,"liveLevel":1,"videoFlag":2,"anchorrich":0,"userId":100000116,"pushDomain":"wspull.xxshow.com","hisViewers":0,"channelAddr":null,"vip":false,"svip":false,"recordPlayUrl":null,"username":"霸霸"},{"income":172,"channelTopic":null,"country":null,"gender":1,"city":null,"appName":"bothlive","channel":"cptest100041","channelImage":"http://incomebucketxxshow2.oss-cn-shanghai.aliyuncs.com/back/F6041019B9CC48DF95860223098233B9.png?x-oss-process=style/imageMiddle","onlineUsers":40,"liveLevel":1,"videoFlag":2,"anchorrich":341,"userId":100000024,"pushDomain":"wspullyt.xxshow.com","hisViewers":0,"channelAddr":null,"vip":false,"svip":false,"recordPlayUrl":null,"username":"孙悟空的大徒弟"}]}]
     */

    private String errcode;
    private String msg;
    private List<ResultBean> result;


    public static class ResultBean {
        /**
         * img : http://picbothlive2.oss-cn-hangzhou.aliyuncs.com/country/Russia.png?x-oss-process=style/imageSmall
         * name : Russia
         * id : 2
         * anchorList : [{"income":40,"channelTopic":null,"country":null,"gender":1,"city":null,"appName":"bothlive","channel":"cptest100044","channelImage":"http://picbothlive1.oss-cn-hangzhou.aliyuncs.com/icon/third/56B022846A764FF6B821DE962DE99DEC.png?x-oss-process=style/imageMiddle","onlineUsers":38,"liveLevel":1,"videoFlag":2,"anchorrich":null,"userId":100005283,"pushDomain":"wspullyt.xxshow.com","hisViewers":0,"channelAddr":null,"vip":false,"svip":false,"recordPlayUrl":null,"username":"蔡彦飞"}]
         */

        private String img;
        private String name;
        private int id;
        private List<AnchorListBean> anchorList;

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public List<AnchorListBean> getAnchorList() {
            return anchorList;
        }

        public void setAnchorList(List<AnchorListBean> anchorList) {
            this.anchorList = anchorList;
        }

        public ResultBean(String img, String name, int id, List<AnchorListBean> anchorList) {
            this.img = img;
            this.name = name;
            this.id = id;
            this.anchorList = anchorList;
        }

        public static class AnchorListBean {
            public AnchorListBean(String image, String username) {
                this.image = image;
                this.username = username;
            }

            private String image;
            private String username;

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }
        }
    }
}
