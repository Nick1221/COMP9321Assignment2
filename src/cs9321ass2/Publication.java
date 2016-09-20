package cs9321ass2;
import java.util.*;

public class Publication 
{
	private String date;
	private String key;
	private String publType;
	private List<String> author;
	private List<String> editor;
	private String title;
	private String bookTitle;
	private String pages;
	private String year;
	private String address;
	private String volume;
	private String journal;
	private String number;
	private String month;
	private String url;
	private String ee;
	private String cdrom;
	private String cite;
	private String publisher;
	private String note;
	private String crossref;
	private String isbn;
	private String series;
	private String school;
	private String chapter;
	private boolean isActive;
	
	public Publication()
	{
		date = "";
		key = "";
		publType = "";
		author = new LinkedList<String>();
		editor = new LinkedList<String>();
		title = "";
		bookTitle = "";
		pages = "";
		year = "";
		address = "";
		volume = "";
		journal = "";
		number = "";
		month = "";
		url = "";
		ee = "";
		cdrom = "";
		cite = "";
		publisher = "";
		note = "";
		crossref = "";
		isbn = "";
		series = "";
		school = "";
		chapter = "";
		isActive = true;
	}
	
	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean doesContainTxt(String toFind)
	{
		boolean has = false;
		if(date.contains(toFind)) has = true;
		if(key.contains(toFind)) has = true;
		if(publType.contains(toFind)) has = true;
		for(String s : author)
		{
			if(s.contains(toFind)) has = true; 
			break;
		}
		for(String z : editor)
		{
			if(z.contains(toFind)) has = true; 
			break;
		}
		if(title.contains(toFind)) has = true;
		if(bookTitle.contains(toFind)) has = true;
		if(pages.contains(toFind)) has = true;
		if(year.contains(toFind)) has = true;
		if(address.contains(toFind)) has = true;
		if(journal.contains(toFind)) has = true;
		if(volume.contains(toFind)) has = true;
		if(number.contains(toFind)) has = true;
		if(month.contains(toFind)) has = true;
		if(url.contains(toFind)) has = true;
		if(ee.contains(toFind)) has = true;
		if(cdrom.contains(toFind)) has = true;
		if(cite.contains(toFind)) has = true;
		if(publisher.contains(toFind)) has = true;
		if(note.contains(toFind)) has = true;
		if(crossref.contains(toFind)) has = true;
		if(isbn.contains(toFind)) has = true;
		if(series.contains(toFind)) has = true;
		if(school.contains(toFind)) has = true;
		if(chapter.contains(toFind)) has = true;
		return has;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}


	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}


	public String getPublType() {
		return publType;
	}
	public void setPublType(String publType) {
		this.publType = publType;
	}

	
	public List<String> getAuthor() {
		return author;
	}
	public void setAuthor(List<String> author) {
		this.author = author;
	}

	
	public List<String> getEditor() {
		return editor;
	}
	public void setEditor(List<String> editor) {
		this.editor = editor;
	}

	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}


	public String getPages() {
		return pages;
	}
	public void setPages(String pages) {
		this.pages = pages;
	}


	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}


	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}


	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}


	public String getJournal() {
		return journal;
	}
	public void setJournal(String journal) {
		this.journal = journal;
	}


	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}


	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}


	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}


	public String getEe() {
		return ee;
	}
	public void setEe(String ee) {
		this.ee = ee;
	}


	public String getCdrom() {
		return cdrom;
	}
	public void setCdrom(String cdrom) {
		this.cdrom = cdrom;
	}


	public String getCite() {
		return cite;
	}
	public void setCite(String cite) {
		this.cite = cite;
	}


	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}


	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}


	public String getCrossref() {
		return crossref;
	}
	public void setCrossref(String crossref) {
		this.crossref = crossref;
	}


	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public String getSeries() {
		return series;
	}
	public void setSeries(String series) {
		this.series = series;
	}

	
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}

	
	public String getChapter() {
		return chapter;
	}
	public void setChapter(String chapter) {
		this.chapter = chapter;
	}


	public String toString()
	{
		String str = "";
		//if(date != "") str = str.concat("mDate is: " + this.date + "   ");
		//if(key != "") str = str.concat("key is: " + this.key + "   ");
		//if(publType != "") str = str.concat("publType is: " + this.publType + "   ");
		if(title != "") str = str.concat("Title is: " + this.title + "  ");
		if(author.size() != 0)
		{
			for(String s : author)
				str = str.concat("Author is: " + s + "   ");
		}
		if(editor.size() != 0)
		{
			for(String z : editor)
				str = str.concat("Editor is: " + z + "   ");
		}
		if(bookTitle != "") str = str.concat("BookTitle is: " + this.bookTitle + "   ");
		if(pages != "") str = str.concat("Page is: " + this.pages + "   ");
		if(year != "") str = str.concat("Year is: " + this.year + "   ");
		//if(address != "") str = str.concat("Address is: " + this.address + "   ");
		if(volume != "") str = str.concat("Volume is: " + this.volume + "   ");
		if(journal != "") str = str.concat("Journal is: " + this.journal + "   ");
		//if(number != "") str = str.concat("Number is: " + this.number + "   ");
		//if(month != "") str = str.concat("Month is: " + this.month + "   ");
		//if(url != "") str = str.concat("Url is: " + this.url + "   ");
		//if(ee != "") str = str.concat("Ee is: " + this.ee + "   ");
		//if(cdrom != "") str = str.concat("Cdrom is: " + this.cdrom + "   ");
		//if(cite != "") str = str.concat("Cite is: " + this.cite + "   ");
		if(publisher != "") str = str.concat("Publisher is: " + this.publisher + "   ");
		//if(note != "") str = str.concat("Note is: " + this.note + "   ");
		//if(crossref != "") str = str.concat("Crossref is: " + this.crossref + "   ");
		if(isbn != "") str = str.concat("Isbn is: " + this.isbn + "   ");
		if(series != "") str = str.concat("Series is: " + this.series + "   ");
		//if(school != "") str = str.concat("School is: " + this.school + "   ");
		//if(chapter != "") str = str.concat("Chapter is: " + this.chapter + "   ");
		return str;
	}
}
