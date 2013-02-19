package ch.silvanv;

import java.io.Serializable;

public class Task
    implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name = "default name";
	private String desc;

	public Task() {
	}

	public Task(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "[" + name + "] [" + desc + "]";
	}
}
