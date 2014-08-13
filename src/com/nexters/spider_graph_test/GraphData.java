package com.nexters.spider_graph_test;

public class GraphData {

	private int width;
	private int height;

	GraphXY top;
	GraphXY rightUp;
	GraphXY rightDown;
	GraphXY leftUp;
	GraphXY leftDown;

	public GraphData(int width, int height) {
		this.width = width;
		this.height = height;

		top = new GraphXY();
		rightUp = new GraphXY();
		rightDown = new GraphXY();
		leftUp = new GraphXY();
		leftDown = new GraphXY();

		setCnt(0.5f);
		setAge(0.5f);
		setGender(0.5f);
		setStudy(0.5f);
		setForigner(0.5f);
	}

	public GraphXY getCnt() {
		return top;
	}

	public void setCnt(float progressPercent) {
		this.top.setX((int) (width * 0.8 * 0.309016 * progressPercent));
		this.top.setY((int) (-height * 0.8 * 0.951056 * progressPercent));
	}

	public GraphXY getAge() {
		return rightUp;
	}

	public void setAge(float progressPercent) {
		this.rightUp.setX((int) (+width * 0.8 * progressPercent));
		this.rightUp.setY((int) (0));
	}

	public GraphXY getGender() {
		return rightDown;
	}

	public void setGender(float progressPercent) {
		this.rightDown.setX((int) (width * 0.8 * 0.309016 * progressPercent));
		this.rightDown.setY((int) (height * 0.8 * 0.951056 * progressPercent));
	}

	public GraphXY getStudy() {
		return leftDown;
	}

	public void setStudy(float progressPercent) {
		this.leftDown.setX((int) (-width * 0.8 * 0.809016 * progressPercent));
		this.leftDown.setY((int) (height * 0.8 * 0.587785 * progressPercent));
	}

	public GraphXY getForigner() {
		return leftUp;
	}

	public void setForigner(float progressPercent) {

		this.leftUp.setX((int) (-width * 0.8 * 0.809016 * progressPercent));
		this.leftUp.setY((int) (-height * 0.8 * 0.587785 * progressPercent));
	}

}