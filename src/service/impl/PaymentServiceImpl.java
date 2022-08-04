package service.impl;

import java.util.List;

import dao.PaymentDao;
import model.Payment;
import service.PaymentService;

public class PaymentServiceImpl implements PaymentService {
	private PaymentDao paymentDao;

	public PaymentServiceImpl(PaymentDao paymentDao) {
		this.paymentDao = paymentDao;
	}

	@Override
	public List<Payment> paymentList() throws Exception {
		return paymentDao.paymentList();
	}

	@Override
	public boolean addPayment(Payment p) throws Exception {
		// TODO Auto-generated method stub
		return paymentDao.addPayment(p);
	}

	@Override
	public Payment getPaymentById(int id) throws Exception {
		// TODO Auto-generated method stub
		return paymentDao.getPaymentById(id);
	}

	@Override
	public boolean editPayment(Payment p, int id) throws Exception {
		// TODO Auto-generated method stub
		return paymentDao.editPayment(p, id);
	}

	@Override
	public boolean deletePayment(int id) throws Exception {
		// TODO Auto-generated method stub
		return paymentDao.deletePayment(id);
	}

	@Override
	public List<Payment> getSearchPayment(String keyword) throws Exception {
		// TODO Auto-generated method stub
		return paymentDao.getSearchPayment(keyword);
	}

}
