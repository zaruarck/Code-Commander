package com.example.CodeCommander;

public class commentsRecyle {

    private String Comments;
    private String Date;
    private String Time;
    private String UserID;
    private String UserName;

    private commentsRecyle()
    {




    }

    public commentsRecyle(String Comments, String Date, String Time, String UserID, String UserName){
        this.Comments = Comments;
        this.Date = Date;
        this.Time = Time;

        this.UserName = UserName;
    }

    public String getComments() {
        return Comments;
    }

    public void setComments(String comments) {
        Comments = comments;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getUserName1() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }
}
