class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        VideoPlayer vp = new VideoPlayer(video_len, pos, op_start, op_end);

        for (String cmd : commands) {
            switch (cmd) {
                case "next":
                    vp.next();
                    System.out.println(vp.getCurrentTime());
                    break;
                case "prev":
                    vp.prev();
                    System.out.println(vp.getCurrentTime());
                    break;
            }
        }
        
        String answer = vp.getCurrentTime();
        return answer;
    }
}

class VideoPlayer {
    String videoLength;
    String pos;
    String opStart;
    String opEnd;
    
    public VideoPlayer(String videoLength, String pos, String opStart, String opEnd) {
        this.videoLength = videoLength;
        this.pos = pos;
        this.opStart = opStart;
        this.opEnd = opEnd;
    }
    
    public void prev() {
        int currentSec = getTimeForSec(pos);
        
        if (isBetweenOp(currentSec)) {
            currentSec = getTimeForSec(opEnd);
            this.pos = secondToFormat(currentSec);
            return;
        }
        
        if (currentSec < 10) {
            currentSec = 0;
        } else {
            currentSec -= 10;
        }
        
        
        this.pos = secondToFormat(currentSec);
        
    }
    
    public void next() {
        int currentSec = getTimeForSec(pos);
        int videoSec = getTimeForSec(videoLength);

        if (isBetweenOp(currentSec)) {
            currentSec = getTimeForSec(opEnd);
        }
        
        if (videoSec - currentSec < 10) {
            currentSec = videoSec;
        } else {
            currentSec += 10;
        }
        
        if (isBetweenOp(currentSec)) {
            currentSec = getTimeForSec(opEnd);
        }
        
        this.pos = secondToFormat(currentSec);
        
    }
    
    public String getCurrentTime() {
        return pos;
    }
    
    private boolean isBetweenOp(int sec) {
        int opStartSec = getTimeForSec(opStart);
        int opEndSec = getTimeForSec(opEnd);
        return opStartSec <= sec && sec < opEndSec;
    }
    
    private int getTimeForSec(String time) {
        String[] temp = time.split(":");
        int min = Integer.parseInt(temp[0]);
        int sec = Integer.parseInt(temp[1]);
        return min * 60 + sec;
    }
    
    private String secondToFormat(int nowSec) {
        int min = nowSec / 60;
        int sec = nowSec % 60;
        return String.format("%02d:%02d", min, sec);
    }
}