package com.github.adrianoluis.fxfp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

public class Transaction {

	private String description;

	private String institutionId;

	private String clientId;

	private String transactionId;

	private String referenceNumber;

	private String industrialCode;

	private String payeeId;

	private String payee;

	private String action;

	private String reminderFirstLine;

	private String transferAccount;

	private String security;

	private String name;

	private String memo;

	private String address;

	private String accountToTransfer;

	private BigDecimal amountTransferred;

	private BigDecimal commission;

	private BigDecimal price;

	private BigDecimal quantity;

	private BigDecimal amount;

	private LocalDate postedOn;

	private ClearedStatus clearedStatus;

	private Type type;

	private Set<String> memoInSplit;

	private Set<String> category;

	private Set<String> categoryInSplit;

	private Set<BigDecimal> amountOfSplit;

	Transaction(String description, String institutionId, String clientId, String transactionId, String referenceNumber, String industrialCode, String payeeId, String payee, String action, String reminderFirstLine, String transferAccount, String security, String name, String memo, String address, String accountToTransfer, BigDecimal amountTransferred, BigDecimal commission, BigDecimal price, BigDecimal quantity, BigDecimal amount, LocalDate postedOn, ClearedStatus clearedStatus, Type type, Set<String> memoInSplit, Set<String> category, Set<String> categoryInSplit, Set<BigDecimal> amountOfSplit) {
		this.description = description;
		this.institutionId = institutionId;
		this.clientId = clientId;
		this.transactionId = transactionId;
		this.referenceNumber = referenceNumber;
		this.industrialCode = industrialCode;
		this.payeeId = payeeId;
		this.payee = payee;
		this.action = action;
		this.reminderFirstLine = reminderFirstLine;
		this.transferAccount = transferAccount;
		this.security = security;
		this.name = name;
		this.memo = memo;
		this.address = address;
		this.accountToTransfer = accountToTransfer;
		this.amountTransferred = amountTransferred;
		this.commission = commission;
		this.price = price;
		this.quantity = quantity;
		this.amount = amount;
		this.postedOn = postedOn;
		this.clearedStatus = clearedStatus;
		this.type = type;
		this.memoInSplit = memoInSplit;
		this.category = category;
		this.categoryInSplit = categoryInSplit;
		this.amountOfSplit = amountOfSplit;
	}

	public static TransactionBuilder builder() {
		return new TransactionBuilder();
	}

	public String getDescription() {
		return this.description;
	}

	public String getInstitutionId() {
		return this.institutionId;
	}

	public String getClientId() {
		return this.clientId;
	}

	public String getTransactionId() {
		return this.transactionId;
	}

	public String getReferenceNumber() {
		return this.referenceNumber;
	}

	public String getIndustrialCode() {
		return this.industrialCode;
	}

	public String getPayeeId() {
		return this.payeeId;
	}

	public String getPayee() {
		return this.payee;
	}

	public String getAction() {
		return this.action;
	}

	public String getReminderFirstLine() {
		return this.reminderFirstLine;
	}

	public String getTransferAccount() {
		return this.transferAccount;
	}

	public String getSecurity() {
		return this.security;
	}

	public String getName() {
		return this.name;
	}

	public String getMemo() {
		return this.memo;
	}

	public String getAddress() {
		return this.address;
	}

	public String getAccountToTransfer() {
		return this.accountToTransfer;
	}

	public BigDecimal getAmountTransferred() {
		return this.amountTransferred;
	}

	public BigDecimal getCommission() {
		return this.commission;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public BigDecimal getQuantity() {
		return this.quantity;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public LocalDate getPostedOn() {
		return this.postedOn;
	}

	public ClearedStatus getClearedStatus() {
		return this.clearedStatus;
	}

	public Type getType() {
		return this.type;
	}

	public Set<String> getMemoInSplit() {
		return this.memoInSplit;
	}

	public Set<String> getCategory() {
		return this.category;
	}

	public Set<String> getCategoryInSplit() {
		return this.categoryInSplit;
	}

	public Set<BigDecimal> getAmountOfSplit() {
		return this.amountOfSplit;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setInstitutionId(String institutionId) {
		this.institutionId = institutionId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public void setIndustrialCode(String industrialCode) {
		this.industrialCode = industrialCode;
	}

	public void setPayeeId(String payeeId) {
		this.payeeId = payeeId;
	}

	public void setPayee(String payee) {
		this.payee = payee;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public void setReminderFirstLine(String reminderFirstLine) {
		this.reminderFirstLine = reminderFirstLine;
	}

	public void setTransferAccount(String transferAccount) {
		this.transferAccount = transferAccount;
	}

	public void setSecurity(String security) {
		this.security = security;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setAccountToTransfer(String accountToTransfer) {
		this.accountToTransfer = accountToTransfer;
	}

	public void setAmountTransferred(BigDecimal amountTransferred) {
		this.amountTransferred = amountTransferred;
	}

	public void setCommission(BigDecimal commission) {
		this.commission = commission;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public void setPostedOn(LocalDate postedOn) {
		this.postedOn = postedOn;
	}

	public void setClearedStatus(ClearedStatus clearedStatus) {
		this.clearedStatus = clearedStatus;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public void setMemoInSplit(Set<String> memoInSplit) {
		this.memoInSplit = memoInSplit;
	}

	public void setCategory(Set<String> category) {
		this.category = category;
	}

	public void setCategoryInSplit(Set<String> categoryInSplit) {
		this.categoryInSplit = categoryInSplit;
	}

	public void setAmountOfSplit(Set<BigDecimal> amountOfSplit) {
		this.amountOfSplit = amountOfSplit;
	}

	public enum Type {
		CREDIT,
		DEBIT,
		INTEREST("INT"),
		DIVIDEND("DIV"),
		SERVICE_CHARGE("SRVCHG"),
		DEPOSIT("DEP"),
		ATM_WITHDRAWAL("ATM"),
		TRANSFER("XFER"),
		CHECK,
		ELECTRONIC_PAYMENT("PAYMENT"),
		CASH_WITHDRAWAL("CASH"),
		ELECTRONIC_PAYROLL_DEPOSIT,
		OTHER,
		// don't change order from here to top
		DIRECT_DEBIT("DIRECTDEBIT"),
		DIRECT_DEPOSIT("DIRECTDEP"),
		FEE,
		POINT_OF_SALE("POS"),
		REPEATING_PAYMENT("REPEATPMT");

		private final String value;

		Type() {
			this.value = null;
		}

		Type(final String header) {
			this.value = header;
		}

		public static Type toEnum(char value) {
			if (Character.isDigit(value)) {
				return Transaction.Type.values()[Character.getNumericValue(value)];
			} else {
				switch (value) {
					case 'C':
						return CHECK;
					case 'D':
						return DEPOSIT;
					case 'P':
						return ELECTRONIC_PAYMENT;
					case 'I':
						return INTEREST;
					case 'E':
						return ELECTRONIC_PAYROLL_DEPOSIT;
					default:
						throw new IllegalArgumentException("Invalid for transaction type identifier: " + value);
				}
			}
		}

		public static Type toEnum(String value) {
			for (Type type : values()) {
				if ((null != type.value && (type.value.equals(value)) || type.name().equals(value))) {
					return type;
				}
			}
			throw new IllegalArgumentException("Invalid for transaction type identifier: " + value);
		}

		public final String value() {
			return value;
		}
	}

	public enum ClearedStatus {
		CLEARED, RECONCILED;

		public static ClearedStatus toEnum(String value) {
			return toEnum(value.charAt(0));
		}

		public static ClearedStatus toEnum(Character value) {
			switch (value) {
				case '*':
				case 'c':
					return CLEARED;
				case 'X':
				case 'R':
					return RECONCILED;
				default:
					throw new IllegalArgumentException("Invalid cleared status identifier: " + value);
			}
		}
	}

	public static class TransactionBuilder {
		private String description;
		private String institutionId;
		private String clientId;
		private String transactionId;
		private String referenceNumber;
		private String industrialCode;
		private String payeeId;
		private String payee;
		private String action;
		private String reminderFirstLine;
		private String transferAccount;
		private String security;
		private String name;
		private String memo;
		private String address;
		private String accountToTransfer;
		private BigDecimal amountTransferred;
		private BigDecimal commission;
		private BigDecimal price;
		private BigDecimal quantity;
		private BigDecimal amount;
		private LocalDate postedOn;
		private ClearedStatus clearedStatus;
		private Type type;
		private Set<String> memoInSplit;
		private Set<String> category;
		private Set<String> categoryInSplit;
		private Set<BigDecimal> amountOfSplit;

		TransactionBuilder() {
		}

		public TransactionBuilder description(String description) {
			this.description = description;
			return this;
		}

		public TransactionBuilder institutionId(String institutionId) {
			this.institutionId = institutionId;
			return this;
		}

		public TransactionBuilder clientId(String clientId) {
			this.clientId = clientId;
			return this;
		}

		public TransactionBuilder transactionId(String transactionId) {
			this.transactionId = transactionId;
			return this;
		}

		public TransactionBuilder referenceNumber(String referenceNumber) {
			this.referenceNumber = referenceNumber;
			return this;
		}

		public TransactionBuilder industrialCode(String industrialCode) {
			this.industrialCode = industrialCode;
			return this;
		}

		public TransactionBuilder payeeId(String payeeId) {
			this.payeeId = payeeId;
			return this;
		}

		public TransactionBuilder payee(String payee) {
			this.payee = payee;
			return this;
		}

		public TransactionBuilder action(String action) {
			this.action = action;
			return this;
		}

		public TransactionBuilder reminderFirstLine(String reminderFirstLine) {
			this.reminderFirstLine = reminderFirstLine;
			return this;
		}

		public TransactionBuilder transferAccount(String transferAccount) {
			this.transferAccount = transferAccount;
			return this;
		}

		public TransactionBuilder security(String security) {
			this.security = security;
			return this;
		}

		public TransactionBuilder name(String name) {
			this.name = name;
			return this;
		}

		public TransactionBuilder memo(String memo) {
			this.memo = memo;
			return this;
		}

		public TransactionBuilder address(String address) {
			this.address = address;
			return this;
		}

		public TransactionBuilder accountToTransfer(String accountToTransfer) {
			this.accountToTransfer = accountToTransfer;
			return this;
		}

		public TransactionBuilder amountTransferred(BigDecimal amountTransferred) {
			this.amountTransferred = amountTransferred;
			return this;
		}

		public TransactionBuilder commission(BigDecimal commission) {
			this.commission = commission;
			return this;
		}

		public TransactionBuilder price(BigDecimal price) {
			this.price = price;
			return this;
		}

		public TransactionBuilder quantity(BigDecimal quantity) {
			this.quantity = quantity;
			return this;
		}

		public TransactionBuilder amount(BigDecimal amount) {
			this.amount = amount;
			return this;
		}

		public TransactionBuilder postedOn(LocalDate postedOn) {
			this.postedOn = postedOn;
			return this;
		}

		public TransactionBuilder clearedStatus(ClearedStatus clearedStatus) {
			this.clearedStatus = clearedStatus;
			return this;
		}

		public TransactionBuilder type(Type type) {
			this.type = type;
			return this;
		}

		public TransactionBuilder memoInSplit(Set<String> memoInSplit) {
			this.memoInSplit = memoInSplit;
			return this;
		}

		public TransactionBuilder category(Set<String> category) {
			this.category = category;
			return this;
		}

		public TransactionBuilder categoryInSplit(Set<String> categoryInSplit) {
			this.categoryInSplit = categoryInSplit;
			return this;
		}

		public TransactionBuilder amountOfSplit(Set<BigDecimal> amountOfSplit) {
			this.amountOfSplit = amountOfSplit;
			return this;
		}

		public Transaction build() {
			return new Transaction(description, institutionId, clientId, transactionId, referenceNumber, industrialCode, payeeId, payee, action, reminderFirstLine, transferAccount, security, name, memo, address, accountToTransfer, amountTransferred, commission, price, quantity, amount, postedOn, clearedStatus, type, memoInSplit, category, categoryInSplit, amountOfSplit);
		}

		public String toString() {
			return "Transaction.TransactionBuilder(description=" + this.description + ", institutionId=" + this.institutionId + ", clientId=" + this.clientId + ", transactionId=" + this.transactionId + ", referenceNumber=" + this.referenceNumber + ", industrialCode=" + this.industrialCode + ", payeeId=" + this.payeeId + ", payee=" + this.payee + ", action=" + this.action + ", reminderFirstLine=" + this.reminderFirstLine + ", transferAccount=" + this.transferAccount + ", security=" + this.security + ", name=" + this.name + ", memo=" + this.memo + ", address=" + this.address + ", accountToTransfer=" + this.accountToTransfer + ", amountTransferred=" + this.amountTransferred + ", commission=" + this.commission + ", price=" + this.price + ", quantity=" + this.quantity + ", amount=" + this.amount + ", postedOn=" + this.postedOn + ", clearedStatus=" + this.clearedStatus + ", type=" + this.type + ", memoInSplit=" + this.memoInSplit + ", category=" + this.category + ", categoryInSplit=" + this.categoryInSplit + ", amountOfSplit=" + this.amountOfSplit + ")";
		}
	}
}
