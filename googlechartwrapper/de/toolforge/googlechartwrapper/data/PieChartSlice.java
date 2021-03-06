package de.toolforge.googlechartwrapper.data;


import de.toolforge.googlechartwrapper.AbstractPieChart;
import de.toolforge.googlechartwrapper.Color;

/**
 * Slice for the {@link AbstractPieChart}.
 * 
 * 
 * @author steffan
 * @version 03/19/09
 * @see AbstractPieChart
 * @see PieChartSliceBuilder
 */
public class PieChartSlice {

	private int value;
	private Color color = null;
	private String label = null;

	/**
	 * Constructs a new PieChartSlice, use the {@link PieChartSliceBuilder} and the {@link PieChartSliceBuilder#build()} method.
	 * 
	 * @param builder the builder {@link PieChartSliceBuilder}
	 * 
	 * @throws IllegalArgumentException if builder is {@code null}
	 * 
	 * @see PieChartSliceBuilder
	 */
	public PieChartSlice(PieChartSliceBuilder builder) {

		if (builder == null) {
			throw new IllegalArgumentException("builder can not be null");
		}
		
		this.value = builder.value;
		this.color = builder.color;
		this.label = builder.label;
	}


	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}


	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}


	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}


	/**
	 * @param color the color to set
	 * 
	 * @throws IllegalArgumentException if color is {@code null}
	 */
	public void setColor(Color color) {
		
		if(color == null)
			throw new IllegalArgumentException("color can not be null");		
		this.color = color;
	}


	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}


	/**
	 * @param label the label to set
	 * 
	 * @throws IllegalArgumentException if label is {@code null}
	 */
	public void setLabel(String label) {
		
		if(label == null)
			throw new IllegalArgumentException("label can not be null");
		this.label = label;
	}

	/**
	 * The builder class for {@link PieChartSlice#PieChartSlice(PieChartSliceBuilder)}.
	 * @author steffan
	 * @see PieChartSlice
	 */
	public static class PieChartSliceBuilder {

		private int value;
		private Color color = null;
		private String label = null;

		public PieChartSliceBuilder(int value) {
			this.value = value;
		}
		
		/**
		 * Adds a color to the {@link PieChartSlice} object.
		 * 
		 * @param color
		 * @return {@link PieChartSliceBuilder}
		 * 
		 * @throws IllegalArgumentException if color is {@code null}
		 */
		public PieChartSliceBuilder color(Color color) {

			if (color == null)
				throw new IllegalArgumentException("color can not be null");

			this.color = color;
			return this;
		}
		
		/**
		 * Adds a color to the {@link PieChartSlice} object.
		 * 
		 * @param awtColor
		 * @return {@link PieChartSliceBuilder}
		 * 
		 * @throws IllegalArgumentException if color is {@code null}
		 * @deprecated use {@link #color(Color)}
		 */
		public PieChartSliceBuilder color(java.awt.Color awtColor) {
			if (awtColor == null)
				throw new IllegalArgumentException("color can not be null");
			return color(new Color(awtColor));
		}
		
		/**
		 * Adds a label to the {@link PieChartSlice} object.
		 * 
		 * @param label
		 * @return {@link PieChartSliceBuilder}
		 * 
		 * @throws IllegalArgumentException if label is {@code null}
		 */
		public PieChartSliceBuilder label(String label) {

			if (label == null)
				throw new IllegalArgumentException("label can not be null");

			this.label = label;

			return this;
		}
		/**
		 * Call this method to build the {@link PieChartSlice} object.
		 * 
		 * @return a {@link PieChartSlice} object
		 */
		public PieChartSlice build() {

			return new PieChartSlice(this);
		}

	}

}
