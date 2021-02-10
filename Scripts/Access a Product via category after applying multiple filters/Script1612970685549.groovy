import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.ebay.com/')

'click btn category'
WebUI.click(findTestObject('Filter Search/Home_Page/btn_Shop by category'))

'click sub category'
WebUI.click(findTestObject('Filter Search/Home_Page/Seb_Cell phones  accessories'))

'click cellphone category'
WebUI.click(findTestObject('Filter Search/Page Cellphone Accesories/Category_Cell Phones  Smartphones'))

'if "All Filter" not in the viewport'
if (WebUI.verifyElementNotPresent(findTestObject('Filter Search/Page_Cell Phones  Smartphones for Sale - Bu_63dd06/btn_All Filters'), 
    0) == true) {
    'click more refinement'
    WebUI.click(findTestObject('Filter Search/Page_Cell Phones  Smartphones for Sale - Bu_63dd06/Page_Cell Phones  Smartphones for Sale - Buy New  Used Phones - eBay/button_More refinementsMore refinements'))
} else {
    WebUI.verifyElementPresent(findTestObject('Filter Search/Page_Cell Phones  Smartphones for Sale - Bu_63dd06/btn_All Filters'), 
        0)

    WebUI.click(findTestObject('Filter Search/Page_Cell Phones  Smartphones for Sale - Bu_63dd06/btn_All Filters'))
}

'filter screen size'
WebUI.click(findTestObject('Filter Search/Filter/span_Screen Size'))

WebUI.click(findTestObject('Filter Search/Filter/input_Screen Size_6.2420in_cbx'))

WebUI.click(findTestObject('Filter Search/Filter/input_Screen Size_620in20or20More_cbx'))

WebUI.click(findTestObject('Filter Search/Filter/input_Screen Size_7.620in_cbx'))

'filter price'
WebUI.click(findTestObject('Filter Search/Filter/span_Price'))

'input from price'
WebUI.setText(findTestObject('Filter Search/Filter/input_IDR_from'), '5000000')

'input to price'
WebUI.setText(findTestObject('Filter Search/Filter/input_IDR_to'), '10000000')

'filter item location'
WebUI.click(findTestObject('Filter Search/Filter/span_Item Location'))

'click on filter tag'
WebUI.click(findTestObject('Filter Search/Filter/input_Asia_location'))

'click on filter tag'
WebUI.click(findTestObject('Filter Search/Filter Count/span_6 in or More'))

'click on filter tag'
WebUI.click(findTestObject('Filter Search/Filter Count/span_6.24 in'))

'click on filter tag'
WebUI.click(findTestObject('Filter Search/Filter Count/span_7.6 in'))

'click on filter tag'
WebUI.click(findTestObject('Filter Search/Filter Count/span_Asia'))

'click on filter tag'
WebUI.click(findTestObject('Filter Search/Filter Count/span_IDR5000000 - IDR10000000'))

'click on filter tag'
WebUI.click(findTestObject('Filter Search/Filter Count/span_Asia'))

'get tag filter class'
Filter_class = WebUI.getAttribute(findTestObject('Filter Search/Filter Count/span_Asia'), 'class')

'get total number filter string'
Tot_Filter = WebUI.getText(findTestObject('Filter Search/Filter Count/span_Filter_total'))

'get only number from string'
Tot_Filter = Tot_Filter.drop(1).take(1)

WebDriver driver = DriverFactory.getWebDriver()

'get all tag with filter tag class with it'
List list = driver.findElements(By.className(Filter_class))

Date today = new Date()

String todaysDate = today.format('MM_dd_yy')

String nowTime = today.format('hh_mm_ss')

'take screen shot and appen timestamp on the name'
WebUI.takeScreenshot(((('Test Screenshots' + todaysDate) + '-') + nowTime) + '.PNG')

'click apply filter'
WebUI.click(findTestObject('Filter Search/Filter Apply/button_Apply'))

println(Tot_Filter)

println(list.size())

'if string filter and number of tag filter equal'
if (Tot_Filter == list.size()) {
    'print to console'
    println('Total filter dan angka SAMA')
}

WebUI.closeBrowser()

