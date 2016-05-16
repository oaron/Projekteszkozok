package csata.jatek;
/**
 * 
 * Harcokat reprezenatlo interface
 *
 */
public interface HarcInterface {
	public Class<?> getJatekosTipus1();

	public Class<?> getJatekosTipus2();

	/**
	 * Elsonti ki nyerte a csatat
	 * @param jatekos1
	 * @param jatekos2
	 * @return vesztes jatekos
	 */
	public Jatekos csataz(Jatekos jatekos1, Jatekos jatekos2);
}
