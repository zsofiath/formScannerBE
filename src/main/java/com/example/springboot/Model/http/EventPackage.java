package com.example.springboot.Model.http;

public class EventPackage {
    private String elementName;
    private String eventName;
    private Point elementPosition;
    private Point screenPosition;
    private Point documentPosition;
    private Block documentSize;
    private String dateTime;

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Point getElementPosition() {
        return elementPosition;
    }

    public void setElementPosition(Point elementPosition) {
        this.elementPosition = elementPosition;
    }

    public Point getScreenPosition() {
        return screenPosition;
    }

    public void setScreenPosition(Point screenPosition) {
        this.screenPosition = screenPosition;
    }

    public Point getDocumentPosition() {
        return documentPosition;
    }

    public void setDocumentPosition(Point documentPosition) {
        this.documentPosition = documentPosition;
    }

    public Block getDocumentSize() {
        return documentSize;
    }

    public void setDocumentSize(Block documentSize) {
        this.documentSize = documentSize;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String timestamp) {
        this.dateTime = timestamp;
    }
}
