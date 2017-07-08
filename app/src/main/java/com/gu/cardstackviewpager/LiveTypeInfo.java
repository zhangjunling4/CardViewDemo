package com.gu.cardstackviewpager;

import java.util.List;

/**
 * Created by admin on 2017/6/14.
 */

public class LiveTypeInfo {

    /**
     * code : 100
     * data : [{"cid":"9","name":"小班课堂","title":"小班课堂历史","business_audit":"T","team_price":"111.00","is_free":"0","ttid":"16","start_time":"2017-04-19 22:00","state":"2","cover":"http://fangtang.jzphp.com/static/team/course/u=3511371127,3475423862&fm=15&gp=0.jpg","mobile":"18339943275","username":"","education":"博士后","seniority":"3","roomid":null,"room_name":null,"rtmppullurl":null,"avatar":"fangtang.jzphp.com/m/molie/images/user-no-avatar.jpg"},{"cid":"9","name":"小班课堂","title":"小班课堂数学","business_audit":"T","team_price":"0.00","is_free":"0","ttid":"23","start_time":"2017-05-19 01:11","state":"2","cover":"http://fangtang.jzphp.com/static/team/course/u=3416897797,2347420954&fm=26&gp=0.jpg","mobile":"17630502329","username":"罗","education":"本科","seniority":"2","roomid":"9329497","room_name":"户外直播语文","rtmppullurl":"rtmp://v61305579.live.126.net/live/eb74cb286476438ebe693e8da526ecb7","avatar":"fangtang.jzphp.com/m/molie/images/user-no-avatar.jpg"}]
     */

    private int code;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * cid : 9
         * name : 小班课堂
         * title : 小班课堂历史
         * business_audit : T
         * team_price : 111.00
         * is_free : 0
         * ttid : 16
         * start_time : 2017-04-19 22:00
         * state : 2
         * cover : http://fangtang.jzphp.com/static/team/course/u=3511371127,3475423862&fm=15&gp=0.jpg
         * mobile : 18339943275
         * username :
         * education : 博士后
         * seniority : 3
         * roomid : null
         * room_name : null
         * rtmppullurl : null
         * avatar : fangtang.jzphp.com/m/molie/images/user-no-avatar.jpg
         */

        private String cid;
        private String name;
        private String title;
        private String business_audit;
        private String team_price;
        private String is_free;
        private String ttid;
        private String start_time;
        private String state;
        private String cover;
        private String mobile;
        private String username;
        private String education;
        private String seniority;
        private String roomid;
        private String room_name;
        private String rtmppullurl;
        private String avatar;

        public String getCid() {
            return cid;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getBusiness_audit() {
            return business_audit;
        }

        public void setBusiness_audit(String business_audit) {
            this.business_audit = business_audit;
        }

        public String getTeam_price() {
            return team_price;
        }

        public void setTeam_price(String team_price) {
            this.team_price = team_price;
        }

        public String getIs_free() {
            return is_free;
        }

        public void setIs_free(String is_free) {
            this.is_free = is_free;
        }

        public String getTtid() {
            return ttid;
        }

        public void setTtid(String ttid) {
            this.ttid = ttid;
        }

        public String getStart_time() {
            return start_time;
        }

        public void setStart_time(String start_time) {
            this.start_time = start_time;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getEducation() {
            return education;
        }

        public void setEducation(String education) {
            this.education = education;
        }

        public String getSeniority() {
            return seniority;
        }

        public void setSeniority(String seniority) {
            this.seniority = seniority;
        }

        public String getRoomid() {
            return roomid;
        }

        public void setRoomid(String roomid) {
            this.roomid = roomid;
        }

        public String getRoom_name() {
            return room_name;
        }

        public void setRoom_name(String room_name) {
            this.room_name = room_name;
        }

        public String getRtmppullurl() {
            return rtmppullurl;
        }

        public void setRtmppullurl(String rtmppullurl) {
            this.rtmppullurl = rtmppullurl;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }
    }
}
