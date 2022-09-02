package ar.edu.unlp.oo1.ejercicio1.impl;

import ar.edu.unlp.oo1.ejercicio1.WallPost;

/**
 * Completar esta clase de acuerdo a lo especificado en el cuadernillo
 *
 */
public class WallPostImpl implements WallPost {

	/**
	 * Complete con su implementación
	 */
	private String text;
	private int likeCount;
	private boolean featured;

	public WallPostImpl() {
		this.text = "Undefined post";
	}
	
	/*
	 * Este mensaje se utiliza para que una instancia de Wallpost se muestre de forma adecuada
	 */
    @Override
    public String toString() {
        return "WallPost {" +
            "text: " + getText() +
            ", likes: '" + getLikes() + "'" +
            ", featured: '" + isFeatured() + "'" +
            "}";
    }


	@Override
	public String getText() {
		return this.text;
	}

	@Override
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public int getLikes() {
		return this.likeCount;
	}

	@Override
	public void like() {
		this.likeCount = this.getLikes() + 1;
	}

	@Override
	public void dislike() {
		if (this.getLikes() > 0) {
			this.likeCount = this.getLikes() - 1;
		}
	}

	@Override
	public boolean isFeatured() {
		return this.featured;
	}

	@Override
	public void toggleFeatured() {
		this.featured = !this.isFeatured();
	}
}
