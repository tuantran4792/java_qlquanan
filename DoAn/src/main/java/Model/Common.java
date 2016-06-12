package Model;
import java.security.MessageDigest;
public class Common {

	public class CodePrefix
    {
        public final String SaleOrder = "PX";
        public final String ReceiptVoucher = "PT";
        public final String DraftSaleOrder = "TX";
        public final String Product = "SP00";
        public final String Customer = "CO00";
    }
	public String setPrefix(int type, long Id)
	{
		CodePrefix code = new CodePrefix();
		String result = "";
		switch (type) {
		case 1:
			result = code.SaleOrder ;
			break;
		case 2:
			result = code.ReceiptVoucher;
			break;
		case 3:
			result = code.DraftSaleOrder ;
			break;
		case 4:
			result = code.Product;
			break;
		case 5: 
			result = code.Customer;
			break;
		default:
			break;
		}
		return result + Long.valueOf(Id + 1).toString() ;
	}
}
