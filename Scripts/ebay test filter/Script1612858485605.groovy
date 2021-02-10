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

WebUI.click(findTestObject('Filter Search/Home_Page/btn_Shop by category'))

WebUI.click(findTestObject('Filter Search/Home_Page/Seb_Cell phones  accessories'))

WebUI.click(findTestObject('Filter Search/Page Cellphone Accesories/Category_Cell Phones  Smartphones'))

if (WebUI.verifyElementNotPresent(findTestObject('Filter Search/Page_Cell Phones  Smartphones for Sale - Bu_63dd06/btn_All Filters'), 
    0) == true) {
    WebUI.click(findTestObject('Filter Search/Page_Cell Phones  Smartphones for Sale - Bu_63dd06/Page_Cell Phones  Smartphones for Sale - Buy New  Used Phones - eBay/button_More refinementsMore refinements'))
} else {
    WebUI.verifyElementPresent(findTestObject('Filter Search/Page_Cell Phones  Smartphones for Sale - Bu_63dd06/btn_All Filters'), 
        0)

    WebUI.click(findTestObject('Filter Search/Page_Cell Phones  Smartphones for Sale - Bu_63dd06/btn_All Filters'))
}

WebUI.click(findTestObject('Filter Search/Filter/span_Screen Size'))

WebUI.click(findTestObject('Filter Search/Filter/input_Screen Size_6.2420in_cbx'))

WebUI.click(findTestObject('Filter Search/Filter/input_Screen Size_620in20or20More_cbx'))

WebUI.click(findTestObject('Filter Search/Filter/input_Screen Size_7.620in_cbx'))

WebUI.click(findTestObject('Filter Search/Filter/span_Price'))

WebUI.setText(findTestObject('Filter Search/Filter/input_IDR_from'), '5000000')

WebUI.setText(findTestObject('Filter Search/Filter/input_IDR_to'), '10000000')

WebUI.click(findTestObject('Filter Search/Filter/span_Item Location'))

WebUI.click(findTestObject('Filter Search/Filter/input_Asia_location'))

WebUI.click(findTestObject('Filter Search/Filter Count/span_6 in or More'))

WebUI.click(findTestObject('Filter Search/Filter Count/span_6.24 in'))

WebUI.click(findTestObject('Filter Search/Filter Count/span_7.6 in'))

WebUI.click(findTestObject('Filter Search/Filter Count/span_Asia'))

WebUI.click(findTestObject('Filter Search/Filter Count/span_IDR5000000 - IDR10000000'))

WebUI.click(findTestObject('Filter Search/Filter Count/span_Asia'))

Filter_class = WebUI.getAttribute(findTestObject('Filter Search/Filter Count/span_Asia'), 'class')

Tot_Filter = WebUI.getText(findTestObject('Filter Search/Filter Count/span_Filter_total'))

Tot_Filter = Tot_Filter.drop(1).take(1)

WebDriver driver = DriverFactory.getWebDriver()

List list = driver.findElements(By.className(Filter_class))

Date today = new Date()

String todaysDate = today.format('MM_dd_yy')

String nowTime = today.format('hh_mm_ss')

WebUI.takeScreenshot("Test Screenshots"+ todaysDate +"-" + nowTime +".PNG")

WebUI.click(findTestObject('Filter Search/Filter Apply/button_Apply'))

println(Tot_Filter)

println(list.size())

if (Tot_Filter == list.size()) {
    println('Total filter dan angka SAMA')
}

WebUI.closeBrowser()

