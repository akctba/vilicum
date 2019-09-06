package br.org.vilicum.util;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DateFormatSymbols;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Classe de configuração de Datas.
 * 
 */
public final class CustomDate implements Serializable {
	private static final long serialVersionUID = 5398099492737673561L;

	/**
	 * Opção Date para formato de data retornado.
	 */
	public static final String FORMATDATE = "dd/MM/yyyy";

	/**
	 * Opção Timestamp para formato de data retornado.
	 */
	private static final Locale LOCALE = new Locale("pt", "BR");

	private static final DateFormatSymbols DFS = new DateFormatSymbols(LOCALE);

	public static final String FORMATDATETIME = "dd/MM/yyyy HH:mm:ss";

	private static final SimpleDateFormat SIMPLEDATEFORMAT = new SimpleDateFormat(
			FORMATDATE, LOCALE);

	private static final SimpleDateFormat SIMPLEHHMMFORMAT = new SimpleDateFormat(
			"HH:mm", LOCALE);

	private static final SimpleDateFormat SIMPLEDATETIMEFORMAT = new SimpleDateFormat(
			FORMATDATETIME, LOCALE);

	private Date data;

	private String dia;

	private String mes;

	private String ano;

	/**
	 * @param data
	 */
	public CustomDate(final String data) {
		super();

		if (data != null && data.length() == FORMATDATE.length()) {
			this.data = parseDate(data);
			Calendar calendar = getCalendar(this.data);
			this.data = calendar.getTime();
			dia = Integer.toString(calendar.get(Calendar.DAY_OF_MONTH));
			mes = Integer.toString(calendar.get(Calendar.MONTH) + 1);

			dia = (dia.trim().length() < 2) ? ("0" + dia.trim()) : dia.trim();
			mes = (mes.trim().length() < 2) ? ("0" + mes.trim()) : mes.trim();

			ano = Integer.toString(calendar.get(Calendar.YEAR));

			calendar = null;
		}
	}

	/**
	 * @param dia
	 * @param mes
	 * @param ano
	 */
	public CustomDate(String dia, String mes, final String ano) {

		super();

		if (dia != null && dia.trim().length() > 0 && mes != null
				&& mes.trim().length() > 0 && ano != null
				&& ano.trim().length() > 0 && ano.trim().length() == 4) {
			if (dia.trim().length() < 2) {
				dia = "0" + dia.trim();
			}
			if (mes.trim().length() < 2) {
				mes = "0" + mes.trim();
			}
			this.dia = dia;
			this.mes = mes;
			this.ano = ano.trim();
			data = parseDate(this.dia + "/" + this.mes + "/" + this.ano);
		}
	}

	/**
	 * @return String
	 */
	public String getAno() {
		return ano;
	}

	/**
	 * @return java.util.Date
	 */
	public java.util.Date getData() {
		return data;
	}

	/**
	 * @return String
	 */
	public String getStringData() {
		return data != null ? (formatDate(data)) : null;
	}

	/**
	 * @return String
	 */
	public String getDia() {
		return dia;
	}

	/**
	 * @return String
	 */
	public String getMes() {
		return mes;
	}

	/**
	 * Obt�m a data atual do sistema.
	 * 
	 * @return Date
	 */
	public static Date getCurrentDate() {
		return getCalendar(null).getTime();
	}

	/**
	 * @return sqlDate atual
	 */
	public static java.sql.Date getCurrentSqlDate() {
		return parseSqlDate(getCurrentDate());
	}

	/**
	 * @return timestamp atual
	 */
	public static java.sql.Timestamp getCurrentTimestamp() {
		return parseTimestamp(getCurrentDate());
	}

	/**
	 * @return Obtem o ano atual.
	 */
	public static int getYear() {
		final Calendar calendar = getCalendar(null);
		return calendar.get(Calendar.YEAR);
	}
	
	/**
	 * @return Obtem o ano da data informada.
	 */
	public static int getYear(Date data) {
		final Calendar calendar = getCalendar(data);
		return calendar.get(Calendar.YEAR);
	}
	
	/**
	 * @return Obtém o mês da data informada.
	 */
	public static int getMonth(Date data) {
		final Calendar calendar = getCalendar(data);
		return calendar.get(Calendar.MONTH)+1;
	}
	
	/**
	 * @return Obtém o dia da data informada.
	 */
	public static int getDay(Date data) {
		final Calendar calendar = getCalendar(data);
		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * @return Obtem a hora atual do sistema
	 */
	public static int getHora() {
		final Calendar calendar = getCalendar(null);
		return calendar.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * @return Obtém o minuto atual do sistema
	 */
	public static int getMinuto() {
		final Calendar calendar = getCalendar(null);
		return calendar.get(Calendar.MINUTE);
	}

	/**
	 * @return Obtém o segundo atual do sistema
	 */
	public static int getSegundo() {
		final Calendar calendar = getCalendar(null);
		return calendar.get(Calendar.MINUTE);
	}

	/**
	 * @param sData
	 *            data String no formato 'dd/MM/yyyy' ou 'dd/MM/yyyy HH:mm:ss'
	 * @return calendar
	 */
	public static Calendar parseCalendar(final String sData) {
		return getCalendar(parseDate(sData));
	}

	/**
	 * Retorna um Calendar com TIME_ZONE configurado. Passar null para obter na
	 * data atual.
	 * 
	 * @param data
	 *            java.util.Date
	 * @return Calendar
	 */
	public static Calendar getCalendar(final java.util.Date data) {
		// TimeZone.setDefault(TIME_ZONE);
		final Calendar calendar = Calendar.getInstance(LOCALE);
		// calendar.setTimeZone(TimeZone.getDefault());
		if (data != null) {
			calendar.setTime(data);
		}
		return calendar;
	}

	/**
	 * Adiciona o n�mero de dias a data.
	 * 
	 * @param data
	 * @param nroDias
	 * @return Date
	 */
	public static Date addDiasDate(final Date data, final int nroDias) {
		return addInDate(data, nroDias, Calendar.DAY_OF_MONTH);
	}

	/**
	 * Adiciona o n�mero de meses a data.
	 * 
	 * @param data
	 * @param nroMeses
	 * @return Date
	 */
	public static Date addMonthsDate(final Date data, final int nroMeses) {
		return addInDate(data, nroMeses, Calendar.MONTH);
	}

	/**
	 * Seta o valor da data em horas, dias, meses ou anos
	 * 
	 * @param data
	 * @param hours
	 * @return Date
	 */
	public static Date setInDate(final Date data, final int nroAdd,
			final int field) {
		final Calendar calendar = getCalendar(data);
		calendar.set(field, nroAdd);
		return calendar.getTime();
	}

	/**
	 * Incrementa o valor da data em dias, meses ou anos.
	 * 
	 * @param data
	 *            Date a ser incrementada.
	 * @param nroAdd
	 *            Quantidade a ser incrementada.
	 * @param field
	 *            Opção para incremento. Ex: Calendar.DAY_OF_MONTH,
	 *            Calendar.MONTH, Calendar.YEAR
	 * @return Date
	 */
	public static Date addInDate(final Date data, final int nroAdd,
			final int field) {
		final Calendar calendar = getCalendar(data);
		calendar.add(field, nroAdd);
		return calendar.getTime();
	}

	/**
	 * Obt�m uma data no format String 'dd/MM/yyyy'
	 * 
	 * @param date
	 * @return String
	 */
	public static String formatDate(final java.util.Date date) {
		String dateFormat = null;

		if (date != null) {
			dateFormat = SIMPLEDATEFORMAT.format(date);
		}

		return dateFormat;
	}

	/**
	 * Obt�m uma data no format String 'dd/MM/yyyy'
	 * 
	 * @param date
	 * @return String
	 */
	public static String formatDate(final java.util.Calendar date) {
		String dateFormat = null;

		if (date != null) {
			dateFormat = SIMPLEDATEFORMAT.format(date.getTime());
		}

		return dateFormat;
	}

	/**
	 * Obt�m uma data no format String 'HH:mm'
	 * 
	 * @param date
	 * @return String
	 */
	public static String formatHHmm(final java.util.Date date) {
		String dateFormat = null;

		if (date != null) {
			dateFormat = SIMPLEHHMMFORMAT.format(date);
		}

		return dateFormat;
	}

	/**
	 * Obt�m uma data no format String 'dd/MM/yyyy HH:mm:ss'
	 * 
	 * @param date
	 * @return String
	 */
	public static String formatDateTime(final java.util.Date date) {
		String dateTimeFormat = null;

		if (date != null) {
			dateTimeFormat = SIMPLEDATETIMEFORMAT.format(date);
		}

		return dateTimeFormat;
	}

	/**
	 * Obt�m um objeto java.util.Date a partir de uma data String no format
	 * 'dd/MM/yyyy HH:mm:ss'.
	 * 
	 * @param dateFormatHHmmss
	 * @return java.util.Date
	 */
	public static java.util.Date parseDateHHmmss(final String dateFormatHHmmss) {
		if (dateFormatHHmmss != null
				&& dateFormatHHmmss.length() == FORMATDATETIME.length()) {
			try {
				return getCalendar(SIMPLEDATETIMEFORMAT.parse(dateFormatHHmmss))
						.getTime();
			} catch (final ParseException e) {
				// LOGGER.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * Retorna um objeto java.util.Date no formato 'dd/MM/yyyy'
	 * 
	 * @param dateStr
	 *            data String no formato 'dd/MM/yyyy' ou 'dd/MM/yyyy HH:mm:ss'
	 * @return java.util.Date
	 */
	public static java.util.Date parseDate(final String dateStr) {
		if (dateStr != null) {
			if (dateStr.length() == FORMATDATE.length()) {
				try {
					return getCalendar(SIMPLEDATEFORMAT.parse(dateStr))
							.getTime();
				} catch (final ParseException e) {
					// LOGGER.error(e.getMessage(), e);
					e.printStackTrace();
				}
			}
			if (dateStr.length() == FORMATDATETIME.length()) {
				try {
					return getCalendar(SIMPLEDATETIMEFORMAT.parse(dateStr))
							.getTime();
				} catch (final ParseException e) {
					// LOGGER.error(e.getMessage(), e);
					e.printStackTrace();
				}
			}
		}
		return null;

	}

	/**
	 * @param dateTime
	 *            data String no formato 'dd/MM/yyyy' ou 'dd/MM/yyyy HH:mm:ss'
	 * @return
	 */
	public static java.sql.Timestamp parseTimestamp(final String dateTime) {
		return parseTimestamp(parseDate(dateTime));
	}

	/**
	 * @param dateTime
	 * @return
	 */
	public static java.sql.Timestamp parseTimestamp(
			final java.util.Date dateTime) {
		if (dateTime == null) {
			return null;
		}

		return new java.sql.Timestamp(dateTime.getTime());
	}

	/**
	 * @param date
	 * @return
	 */
	public static java.sql.Date parseSqlDate(final java.util.Date date) {
		if (date == null) {
			return null;
		}

		return new java.sql.Date(date.getTime());
	}

	/**
	 * @param date
	 * @return
	 */
	public static java.sql.Date parseSqlDate(final String date) {
		return parseSqlDate(parseDate(date));
	}

	/**
	 * Retorna um objeto java.sql.Date no formato 'dd/MM/yyyy'
	 * 
	 * @param dateFormat
	 *            data String no formato 'dd/MM/yyyy' ou 'dd/MM/yyyy HH:mm:ss'
	 * @param formatType
	 * @return java.sql.Date
	 */
	public static Date parseSqlDate(final String dateFormat,
			final String formatType) {
		java.sql.Date sqlDate = null;

		if (dateFormat != null && formatType != null) {
			try {
				if ((FORMATDATE.equals(formatType) && dateFormat.length() == FORMATDATE
						.length())
						|| (FORMATDATETIME.equals(formatType) && dateFormat
								.length() == FORMATDATETIME.length())) {
					Calendar calendar = getCalendar(new SimpleDateFormat(
							formatType, LOCALE).parse(dateFormat));
					sqlDate = new java.sql.Date(calendar.getTimeInMillis());
					calendar = null;
				}
			} catch (final ParseException e) {
				// LOGGER.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		return sqlDate;

	}

	/**
	 * Verifica se o objeto java.util.Date passado como par�metro � um
	 * S�bado ou um Domingo e retorna o nome dia como string. Se o par�metro
	 * Date for null, assume a data atual.
	 * 
	 * @param data
	 * @return String
	 * @throws Exception
	 */
	public static String getWeekendName(Date data) throws Exception {
		if (data == null) {
			data = getCurrentDate();
		}

		Calendar ca = getCalendar(data);
		final int dia = ca.get(Calendar.DAY_OF_WEEK);
		ca = null;

		if (dia == Calendar.SUNDAY) {
			return "Domingo";
		} else if (dia == Calendar.SATURDAY) {
			return "Sábado";
		}
		return null;
	}

	/**
	 * M�todo que retorna a descri��o do dia da semana de acordo com a data
	 * passada como parametro.
	 * 
	 * @param data
	 * @return String
	 */
	public static String getWeekDay(final Date data) {
		if (data == null) {
			return "";
		}
		Calendar ca = getCalendar(data);
		final int diaSemana = ca.get(Calendar.DAY_OF_WEEK);
		ca = null;
		final String[] diasDaSemana = DFS.getWeekdays();
		return diasDaSemana[diaSemana];
	}

	/**
	 * Método que retorna a descrção do mês de acordo com a data passada como parâmetro.
	 * 
	 * @param data
	 * @return String
	 */
	public static String getMonthYear(final Date data) {
		if (data == null) {
			return "";
		}
		Calendar ca = getCalendar(data);
		final int mes = ca.get(Calendar.MONTH);
		ca = null;
		final String[] meses = DFS.getMonths();
		return meses[mes];
	}

	public static String getDayMonth(final Date data) {
		if (data == null) {
			return "";
		}
		final Calendar ca = getCalendar(data);
		final int dia = ca.get(Calendar.DAY_OF_MONTH);
		final int mes = ca.get(Calendar.MONTH) + 1;
		return dia + "/" + mes;
	}
	
	public static String getYMD(final Date data) {
		if (data == null) {
			return "";
		}
		final Calendar ca = getCalendar(data);
		final int dia = ca.get(Calendar.DAY_OF_MONTH);
		final int mes = ca.get(Calendar.MONTH) + 1;
		final int ano = ca.get(Calendar.YEAR);
		return ano+"-"+mes+"-"+dia;
	}

	/**
	 * Retorna o numero de anos entre as datas.
	 * 
	 * @param initDate
	 * @param endDate
	 * @return
	 */
	public static int getNumberYears(final Calendar initDate,
			final Calendar endDate) {
		if (initDate == null || endDate == null) {
			return 0;
		}

		long milis = (endDate.getTimeInMillis() - initDate.getTimeInMillis());

		milis += 3600000L; // 1 hora para compensar horário de verão
		return (int) (milis / 31536000000L); // milissegundos por ano
	}

	/**
	 * M�todo que retorna o número de dias entre duas datas passadas como
	 * parametro.
	 * 
	 * @param initDate
	 * @param endDate
	 * @return int
	 */
	public static int getNumberDays(final Date initDate, final Date endDate) {
		if (initDate == null || endDate == null) {
			return 0;
		}
		final Calendar c1 = getCalendar(initDate);
		final Calendar c2 = getCalendar(endDate);
		return getNumberDays(c1, c2);
	}

	/**
	 * M�todo que retorna o número de dias entre duas datas passadas como
	 * parametro.
	 * 
	 * @param initDate
	 * @param endDate
	 * @return int
	 */
	public static int getNumberDays(final Calendar c1, final Calendar c2) {
		if (c1 == null || c2 == null) {
			return 0;
		}
		long milis = (c2.getTimeInMillis() - c1.getTimeInMillis());

		milis += 3600000L; // 1 hora para compensar hor�rio de ver�o
		return (int) (milis / 86400000); // milissegundos por dia
	}

	/**
	 * M�todo que retorna String com a diferen�a de dias/horas/minutos entre
	 * duas datas passadas como parametro.
	 * 
	 * @param initDate
	 * @param endDate
	 * @return String
	 */
	public static String getNumberDaysHours(final java.util.Date initDate,
			final java.util.Date endDate) {
		if (initDate == null || endDate == null) {
			return null;
		}
		final Calendar c1 = getCalendar(initDate);
		final Calendar c2 = getCalendar(endDate);
		final long milis = (c2.getTimeInMillis() - c1.getTimeInMillis());

		final StringBuffer dif = new StringBuffer();

		if ((milis / 86400000) > 0) {
			dif.append(String.valueOf(milis / 86400000));
			dif.append(" dia(s) ");
		}
		if (((milis / 1000 / 60 / 60) % 24) > 0) {
			dif.append((milis / 1000 / 60 / 60) % 24);
			dif.append(" hora(s) ");
		}
		dif.append((milis / 1000 / 60) % 60);
		dif.append(" minuto(s)");
		return dif.toString();
	}

	/**
	 * Metodo que retorna o total de S�bados e Domingos em um determinado
	 * intervalo.
	 * 
	 * @param dataInicial
	 *            Data inicial do intervalo.
	 * @param dataFinal
	 *            Data final do intervalo.
	 * @return int
	 */
	public static synchronized int getTotalWeekend(
			final java.util.Date dataInicial, final java.util.Date dataFinal) {
		final Calendar calIni = getCalendar(dataInicial);
		final Calendar calFinal = getCalendar(dataFinal);
		return calcNumberWeekend(calIni, calFinal, 0);
	}

	/**
	 * Metodo que calcula o n�mero de S�bados e Domingos em um determinado
	 * intervalo e retorna o resultado.
	 * 
	 * @param calIni
	 * @param calFinal
	 * @param weekends
	 * @return int
	 */
	private static int calcNumberWeekend(final Calendar calIni,
			final Calendar calFinal, int weekends) {
		if (calIni.getTime().compareTo(calFinal.getTime()) <= 0) {
			final int dia = calIni.get(Calendar.DAY_OF_WEEK);
			if (dia == Calendar.SUNDAY) {
				calIni.add(Calendar.DAY_OF_MONTH, 6);
				weekends++;
			} else if (dia == Calendar.SATURDAY) {
				calIni.add(Calendar.DAY_OF_MONTH, 1);
				weekends++;
			} else {
				while (calIni.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY) {
					calIni.add(Calendar.DAY_OF_MONTH, 1);
				}
			}
			weekends = +calcNumberWeekend(calIni, calFinal, weekends);
		}

		return weekends;
	}

	/**
	 * Verifica se o objeto java.util.Date passado como par�metro � um
	 * S�bado ou um Domingo. Se o par�metro Date for null, retorna false.
	 * 
	 * @param data
	 * @return boolean
	 * @throws Exception
	 */
	public static boolean isWeekend(final java.util.Date data) throws Exception {
		if (data == null) {
			return false;
		}

		Calendar ca = getCalendar(data);
		final int dia = ca.get(Calendar.DAY_OF_WEEK);
		ca = null;
		return (dia == Calendar.SUNDAY || dia == Calendar.SATURDAY);
	}

	/**
	 * M�todo toString().
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return getDia() + "/" + getMes() + "/" + getAno();
	}

	/**
	 * Verifica se a String passada como par�metro � uma data v�lida. Se o
	 * par�metro for null, retorna false.
	 * 
	 * @param data
	 * @return boolean
	 */
	public static boolean isDate(final String data) {
		return (CustomDate.parseDate(data) != null);

	}

	/**
	 * M�todo que calcula a idade com base no parametro data de nascimento.
	 * 
	 * @param dataNascimento
	 * @return A idade como inteiro.
	 */
	public static int getIdade(final Date date) {
		final Calendar birthdate = getCalendar(null);
		birthdate.setTime(date);
		final Calendar now = getCalendar(null);
		int age = now.get(Calendar.YEAR) - birthdate.get(Calendar.YEAR);
		birthdate.add(Calendar.YEAR, age);
		if (now.before(birthdate)) {
			age--;
		}
		return age;
	}

	/**
	 * M�todo que calcula o tempo em horas/minuto/segundo com base no
	 * parametro tempo em milisegundos.
	 * 
	 * @param tempo
	 * @return tempo no formato HH:mm:ss.
	 */
	public static String time(final double tempo) {
		final double hr = (tempo / (1000d * 60d * 60d));
		final double min = (tempo / (1000d * 60d)) % 60;
		final double seg = (tempo / (1000d)) % 60;

		return convert(hr) + ":" + convert(min) + ":" + convert(seg);
	}

	/**
	 * M�todo que calcula o tempo em dias/horas/minuto/segundo com base no
	 * parametro tempo em milisegundos, descontando os finais de semana.
	 * 
	 * @param tempo
	 * @return tempo no formato HH:mm:ss.
	 */
	public static String time(double tempo, final double weekend) {
		double dia, hr, min, seg;

		if (tempo > 86400000) {
			tempo = tempo - weekend;
			dia = (tempo / (1000 * 60 * 60 * 24));
			hr = ((dia - (int) dia) * 24);
			min = ((hr - (int) hr) * 60);
			seg = (int) ((min - (int) min) * 60);
			return convert(dia) + "d " + convert(hr) + ":" + convert(min) + ":"
					+ convert(seg);
		}
		return time(tempo);
	}

	/**
	 * M�todo que converte um valor de tempo de double para long
	 * 
	 * @param vlr
	 * @return
	 */
	public static String convert(final double vlr) {
		final Long l = Long.valueOf(new Double(vlr).longValue());
		return l.toString().length() >= 2 ? l.toString() : ("0" + l.toString());
	}

	/**
	 * Verifica se o valor da date desta inst�ncia de Date � igual ao de uma
	 * outra inst�ncia.
	 * 
	 * @param date
	 *            data do tipo Date, no formato(aaaa,MM,dd)
	 * @param otherDate
	 * @return True, se a data da Date for igual a uma outra inst�ncia
	 */
	public static boolean compare(final Date date, final Date otherDate) {
		return formatDate(date).equals(formatDate(otherDate));
	}

	public static boolean isSameYear(final Date dateA, final Date dateB) {
		final Calendar cal = Calendar.getInstance();
		cal.setTime(dateA);
		final int yearA = cal.get(Calendar.YEAR);
		cal.setTime(dateB);
		final int yearB = cal.get(Calendar.YEAR);

		return yearA == yearB ? true : false;
	}

	/**
	 * Configura a hora/min/seg/mili para meia noite (00:00:00:0000) no dia
	 * informado
	 * 
	 * @param date
	 * @return
	 */
	public static Date setMidnightInDate(Date date) {
		date = setInDate(date, 0, Calendar.HOUR_OF_DAY); // Calendar.HOUR estava colocando meio dia
		date = setInDate(date, 0, Calendar.MINUTE);
		date = setInDate(date, 0, Calendar.SECOND);
		date = setInDate(date, 0, Calendar.MILLISECOND);

		return date;
	}

	/**
	 * Configura a data com o ultimo minuto do dia. (23:59:59)
	 * 
	 * @param date
	 * @return
	 */
	public static Date setEndDay(Date date) {
		if (date != null) {
			date = setInDate(date, 23, Calendar.HOUR_OF_DAY); // Calendar.HOUR estava colocando meio dia
			date = setInDate(date, 59, Calendar.MINUTE);
			date = setInDate(date, 59, Calendar.SECOND);
			date = setInDate(date, 999, Calendar.MILLISECOND);
		}
		return date;
	}

	/**
	 * Retorna a Zero Hora do dia seguinte da data informada.
	 * 
	 * @param date
	 * @return
	 */
	public static Date setMidnightNextDay(Date date) {
		if (date != null) {
			date = addDiasDate(date, 1);
			date = setMidnightInDate(date);
		}
		return date;
	}

	/**
	 * Configura o hor�rio em uma data.
	 * 
	 * @param date
	 * @param hora
	 * @param minuto
	 * @return
	 */
	public static Timestamp setHourInDate(Date date, final int hora,
			final int minuto) {
		date = setInDate(date, hora, Calendar.HOUR_OF_DAY);
		date = setInDate(date, minuto, Calendar.MINUTE);
		date = setInDate(date, 0, Calendar.SECOND);
		date = setInDate(date, 0, Calendar.MILLISECOND);

		final Timestamp nDate = new Timestamp(date.getTime());

		return nDate;
	}

	/**
	 * Converte data para Timestamp
	 * 
	 * @param date
	 * @return
	 */
	public static Timestamp parseDate(final Date date) {
		if (date != null) {
			final Timestamp timestamp = new Timestamp(date.getTime());
			return timestamp;
		}
		return null;
	}

	public static Date getFirstDayNextMonth() {
		final Calendar ca = getCalendar(null);
		final int mes = ca.get(Calendar.MONTH) + 1;
		final int ano = ca.get(Calendar.YEAR);

		final Calendar c1 = new GregorianCalendar(ano, mes, 1);
		return c1.getTime();
	}

	/**
	 * @param date
	 * @return
	 */
	public static java.sql.Date toSqlDate(final Calendar date) {
		return new java.sql.Date(date.getTimeInMillis());
	}

	/**
	 * @param date
	 * @return
	 */
	public static java.sql.Date toSqlDate(final java.util.Date date) {
		if (date != null) {
			return new java.sql.Date(date.getTime());
		} else {
			return null;
		}
	}

	/**
	 * M�todo que verifica se a data se encontra dentro do periodo informado
	 * (incluive).
	 * 
	 * @param date
	 *            Data a ser verificada. Aceita objetos java.util.Date,
	 *            java.sql.Date e Calendar.
	 * @param ini
	 *            Data de inicio do per�odo a ser verificado. Aceita objetos
	 *            java.util.Date, java.sql.Date e Calendar.
	 * @param fim
	 *            Data de termino do per�odo a ser verificado. Aceita objetos
	 *            java.util.Date, java.sql.Date e Calendar.
	 * @return true se a data (primeiro argumento) se encontra entre o per�odo
	 *         informado (segundo e terceiro parametro).
	 */
	public static boolean isInPeriod(final Object date, final Object ini,
			final Object fim) {
		long lDate = 0;
		long lIni = 0;
		long lFim = 0;

		if (date == null) {
			throw new IllegalArgumentException(
					"Argumento date n�o pode ser nulo.");
		}
		if (ini == null) {
			throw new IllegalArgumentException(
					"Argumento ini n�o pode ser nulo.");
		}
		if (fim == null) {
			throw new IllegalArgumentException("Argumento fim pode ser nulo.");
		}

		// date
		if (date instanceof java.util.Date) {
			lDate = ((java.util.Date) date).getTime();
		} else if (date instanceof java.sql.Date) {
			lDate = ((java.sql.Date) date).getTime();
		} else if (date instanceof Calendar) {
			lDate = ((Calendar) date).getTimeInMillis();
		} else {
			throw new IllegalArgumentException(
					"Metodo aceita objetos java.util.Date, java.sql.Date e Calendar. (argumento 1)");
		}

		// ini
		if (ini instanceof java.util.Date) {
			final java.util.Date iniC = setMidnightInDate((java.util.Date) ini);
			lIni = iniC.getTime();
		} else if (ini instanceof java.sql.Date) {
			final java.util.Date iniC = setMidnightInDate((java.sql.Date) ini);
			lIni = iniC.getTime();
		} else if (ini instanceof Calendar) {
			final Calendar iniC = setMidnightInDate((Calendar) ini);
			lIni = iniC.getTimeInMillis();
		} else {
			throw new IllegalArgumentException(
					"Metodo aceita objetos java.util.Date, java.sql.Date e Calendar. (argumento 2)");
		}

		// fim (subtrai 1 milesimo para se manter no mesmo dia.
		if (fim instanceof java.util.Date) {
			final java.util.Date fimC = setMidnightNextDay((java.util.Date) fim);
			lFim = fimC.getTime() - 1;
		} else if (fim instanceof java.sql.Date) {
			final java.util.Date fimC = setMidnightNextDay((java.sql.Date) fim);
			lFim = fimC.getTime() - 1;
		} else if (fim instanceof Calendar) {
			final Calendar fimC = setMidnightNextDay((Calendar) fim);
			lFim = fimC.getTimeInMillis() - 1;
		} else {
			throw new IllegalArgumentException(
					"Metodo aceita objetos java.util.Date, java.sql.Date e Calendar. (argumento 3)");
		}

		return lDate >= lIni && lDate <= lFim;
	}

	/**
	 * Verifica se os periodos s�o coincidentes (sobrepostos).
	 * 
	 * @param iniA
	 *            inicio do periodo A
	 * @param fimA
	 *            fim do periodo A
	 * @param iniB
	 *            inicio do periodo B
	 * @param fimB
	 *            fim do periodo B
	 * @return retorna true se s�o periodos sobrepostos (n�o v�lidos)
	 * @throws BusinessException
	 */
	public static boolean periodCoinciding(final Object iniA,
			final Object fimA, final Object iniB, final Object fimB)
			throws Exception {
		long lIniA = 0;
		long lFimA = 0;
		long lIniB = 0;
		long lFimB = 0;

		if (iniA == null) {
			throw new IllegalArgumentException(
					"Argumento iniA n�o pode ser nulo.");
		}
		if (fimA == null) {
			throw new IllegalArgumentException(
					"Argumento fimA n�o pode ser nulo.");
		}
		if (iniB == null) {
			throw new IllegalArgumentException(
					"Argumento iniB n�o pode ser nulo.");
		}
		if (fimB == null) {
			throw new IllegalArgumentException(
					"Argumento fimB n�o pode ser nulo.");
		}

		if (iniA instanceof java.util.Date) {
			lIniA = ((java.util.Date) iniA).getTime();
		} else if (iniA instanceof java.sql.Date) {
			lIniA = ((java.sql.Date) iniA).getTime();
		} else if (iniA instanceof Calendar) {
			lIniA = ((Calendar) iniA).getTimeInMillis();
		} else {
			throw new IllegalArgumentException(
					"Metodo aceita objetos java.util.Date, java.sql.Date e Calendar. (argumento 1)");
		}

		if (fimA instanceof java.util.Date) {
			lFimA = ((java.util.Date) fimA).getTime();
		} else if (fimA instanceof java.sql.Date) {
			lFimA = ((java.sql.Date) fimA).getTime();
		} else if (fimA instanceof Calendar) {
			lFimA = ((Calendar) fimA).getTimeInMillis();
		} else {
			throw new IllegalArgumentException(
					"Metodo aceita objetos java.util.Date, java.sql.Date e Calendar. (argumento 2)");
		}

		if (iniB instanceof java.util.Date) {
			lIniB = ((java.util.Date) iniB).getTime();
		} else if (iniB instanceof java.sql.Date) {
			lIniB = ((java.sql.Date) iniB).getTime();
		} else if (iniB instanceof Calendar) {
			lIniB = ((Calendar) iniB).getTimeInMillis();
		} else {
			throw new IllegalArgumentException(
					"Metodo aceita objetos java.util.Date, java.sql.Date e Calendar. (argumento 3)");
		}

		if (fimB instanceof java.util.Date) {
			lFimB = ((java.util.Date) fimB).getTime();
		} else if (fimB instanceof java.sql.Date) {
			lFimB = ((java.sql.Date) fimB).getTime();
		} else if (fimB instanceof Calendar) {
			lFimB = ((Calendar) fimB).getTimeInMillis();
		} else {
			throw new IllegalArgumentException(
					"Metodo aceita objetos java.util.Date, java.sql.Date e Calendar. (argumento 4)");
		}

		// Verificar se data inicial � menor que data final
		if (lIniA > lFimA || lIniB > lFimB) {
			throw new Exception("Data inicial maior que data final");
		}

		// Verificar se existe sobreposi��o
		// InicioB come�ando antes de InicioA e FimB depois de InicioA
		final boolean condicao1 = (lIniB <= lIniA && lFimB >= lIniA);
		// InicioB come�ando depois de InicioA e antes de FimA
		final boolean condicao2 = (lIniB >= lIniA && lIniB <= lFimA);
		// InicioA come�ando antes de InicioB e FimA depois de InicioB
		final boolean condicao3 = (lIniA <= lIniB && lFimA >= lIniB);
		// InicioA come�ando depois de InicioB e antes de FimB
		final boolean condicao4 = (lIniA >= lIniB && lIniA <= lFimB);

		return condicao1 || condicao2 || condicao3 || condicao4;
	}

	public static Calendar setMidnightNextDay(final Calendar dt) {
		Date date = dt.getTime();
		date = setMidnightNextDay(date);
		return getCalendar(date);
	}

	public static Calendar setMidnightInDate(final Calendar dt) {
		Date date = dt.getTime();
		date = setMidnightInDate(date);
		return getCalendar(date);
	}

	/**
	 * Devido a um bug do metodo toGregorianCalendar, da classe
	 * XMLGregorianCalendar, tive de implementar este. O bug estava jogando
	 * v�rias datas para 01/01/1970.
	 * 
	 * @param xml
	 * @return
	 */
	public static java.util.Date xmlToDate(final XMLGregorianCalendar xml) {

		if (xml == null) {
			return null;
		}

		final DecimalFormat yF = new DecimalFormat("0000");

		Date date = null;

		final StringBuffer sData = new StringBuffer();
		if (xml.getDay() < 10) {
			sData.append("0");
		}
		sData.append(xml.getDay());
		sData.append("/");
		if (xml.getMonth() < 10) {
			sData.append("0");
		}
		sData.append(xml.getMonth());
		sData.append("/");
		final int year = xml.getYear();
		sData.append(yF.format(year));
		if (xml.getHour() > 0) {
			sData.append(" ");
			if (xml.getHour() < 10) {
				sData.append("0");
			}
			sData.append(xml.getHour());
			sData.append(":");
			if (xml.getMinute() < 10) {
				sData.append("0");
			}
			sData.append(xml.getMinute());
			sData.append(":");
			if (xml.getSecond() < 10) {
				sData.append("0");
			}
			sData.append(xml.getSecond());

			// 'dd/MM/yyyy HH:mm:ss'
			date = parseDateHHmmss(sData.toString());
		} else {
			// 'dd/MM/yyyy'
			date = parseDate(sData.toString());
		}

		return date;
	}

	/**
	 * Devido a um bug do metodo toGregorianCalendar, da classe
	 * XMLGregorianCalendar, tive de implementar este. O bug estava jogando
	 * v�rias datas para 01/01/1970.
	 * 
	 * @param xmlD
	 *            elemento contendo a data
	 * @param xmlH
	 *            elemento contendo a hora
	 * @return Timestamp com data e hora
	 */
	public static java.sql.Timestamp xmlToDateHour(
			final XMLGregorianCalendar xmlD, final XMLGregorianCalendar xmlH) {

		if (xmlD == null) {
			return null;
		}

		final DecimalFormat yF = new DecimalFormat("0000");

		Timestamp date = null;

		final StringBuffer sData = new StringBuffer();
		if (xmlD.getDay() < 10) {
			sData.append("0");
		}
		sData.append(xmlD.getDay());
		sData.append("/");
		if (xmlD.getMonth() < 10) {
			sData.append("0");
		}
		sData.append(xmlD.getMonth());
		sData.append("/");
		final int year = xmlD.getYear();
		sData.append(yF.format(year));
		if (xmlH != null) {
			sData.append(" ");
			if (xmlH.getHour() < 10) {
				sData.append("0");
			}
			sData.append(xmlH.getHour());
			sData.append(":");
			if (xmlH.getMinute() < 10) {
				sData.append("0");
			}
			sData.append(xmlH.getMinute());
			sData.append(":");
			if (xmlH.getSecond() < 10) {
				sData.append("0");
			}
			sData.append(xmlH.getSecond());

			// 'dd/MM/yyyy HH:mm:ss'
			date = parseTimestamp(sData.toString());
		} else {
			// 'dd/MM/yyyy'
			date = parseTimestamp(sData.toString());
		}

		return date;
	}

	/**
	 * Verifica se a data a maior que 01/01/1900 e menor que a data atual.
	 * 
	 * @param data
	 * @return
	 */
	public static boolean validaData(final java.util.Date data) {
		boolean dtVal = true;

		if (data == null) {
			dtVal = false;
		} else {
			// validar data (nao pode ser futura)
			if (data.after(CustomDate.getCurrentDate())) {
				dtVal = false;
			}
			final java.util.Date limiteMin = CustomDate.parseDate("01/01/1900");
			if (data.before(limiteMin)) {
				dtVal = false;
			}
		}

		return dtVal;
	}
	
	/**
	 * Varifica a validade de uma data. Utilizado para verificar exclusão lógica.
	 * @param data
	 * @return
	 */
	public static boolean vencida(final java.util.Date data) {
		boolean dtVal = false;

		if (data == null) {
			dtVal = false;
		} else {
			// validar data (nao pode ser passado)
			if (data.before(CustomDate.getCurrentDate())) {
				dtVal = true;
			}
		}
		return dtVal;
	}

	/**
	 * Retorna o primeiro dia do mês da data informada
	 */
	public static Calendar getFirstDay(Date dt) {
		int month = getMonth(dt);
		int year = getYear(dt);
		
		String ndt = "01/";
		if (month < 10) {
			ndt = ndt + "0" + month + "/";
		} else {
			ndt = ndt + month + "/";
		}
		ndt = ndt + year;
		
		return parseCalendar(ndt);
	}
	
	public static Calendar getLastDay(Date dt) {
		
		int month = getMonth(dt)-1;
		int year = getYear(dt);
		
		Calendar aux = Calendar.getInstance();
		aux.set(Calendar.MONTH, month);
		aux.set(Calendar.YEAR, year);
		aux.set(Calendar.DAY_OF_MONTH, 1);
		aux.set(Calendar.DATE, aux.getActualMaximum(Calendar.DATE));
		
		return aux;
	}
	
	public static Date getFirstDaySemester(Date dt) {
		int month = getMonth(dt);
		String m = null;
		
		if (month<=6) {
			m = "01/01/" + getYear(dt);
		} else {
			m = "01/07/" + getYear(dt);
		}
		
		return parseDate(m);
	}
	
	public static Date getLastDaySemester(Date dt) {
		int month = getMonth(dt);
		String m = null;
		
		if (month<=6) {
			m = "30/06/" + getYear(dt);
		} else {
			m = "31/12/" + getYear(dt);
		}
		
		return parseDate(m);
	}

}
