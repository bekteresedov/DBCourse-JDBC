package dao;

import java.util.List;

import model.Payment;

public interface PaymentDao {
	public List<Payment> paymentList() throws Exception;

	public boolean addPayment(Payment p) throws Exception;

	public Payment getPaymentById(int id) throws Exception;

	public boolean editPayment(Payment p, int id) throws Exception;
	public boolean deletePayment(int id)throws Exception;
	public List<Payment>getSearchPayment(String keyword)throws Exception;

}
