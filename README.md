# Banking System Simulation with Multithreading

## Overview

This project is a simulation of a banking system, designed to demonstrate the use of multithreading for improved performance. The system handles various banking operations such as account creation, deposits, withdrawals, and balance inquiries. By leveraging multithreading, we aim to enhance the responsiveness and efficiency of these operations, especially under high load.

## Features

- **Account Management**: Create and manage multiple bank accounts.
- **Transactions**: Perform deposits, withdrawals, and balance inquiries.
- **Concurrency**: Utilize multithreading to handle multiple transactions simultaneously.
- **Synchronization**: Ensure data consistency and thread safety with appropriate synchronization mechanisms.

## Getting Started

### Prerequisites

- **Python 3.8+**: Ensure you have Python installed. You can download it from [python.org](https://www.python.org/downloads/).
- **Git**: For cloning the repository. You can download it from [git-scm.com](https://git-scm.com/downloads).

### Installation

1. **Clone the repository**:
    ```bash
    git clone https://github.com/your-username/banking-system-simulation.git
    cd banking-system-simulation
    ```

2. **Install dependencies**:
    ```bash
    pip install -r requirements.txt
    ```

### Running the Simulation

To run the banking system simulation, execute the following command in your terminal:
```bash
python main.py
```

### Multithreading Implementation

The main objective of this update is to improve performance using multithreading. Here are the key points:

- **Thread Pooling**: We use a thread pool to manage a pool of worker threads efficiently. This reduces the overhead of creating and destroying threads.
- **Locking Mechanisms**: We implement locks to ensure that account transactions are thread-safe. This prevents race conditions and ensures data consistency.
- **Performance Metrics**: We include timing functions to measure the performance improvement due to multithreading.

## Code Structure

- `main.py`: The entry point of the simulation.
- `account.py`: Contains the `Account` class, which encapsulates account-related operations.
- `bank.py`: Manages multiple accounts and coordinates transactions.
- `thread_manager.py`: Manages threading operations and synchronization.
- `tests/`: Contains unit tests for different components of the system.

## Usage

### Creating an Account

```python
from bank import Bank

bank = Bank()
account_id = bank.create_account("John Doe")
print(f"Account created with ID: {account_id}")
```

### Making a Deposit

```python
bank.deposit(account_id, 500)
print(f"Deposited 500 into account {account_id}")
```

### Withdrawing Money

```python
bank.withdraw(account_id, 200)
print(f"Withdrew 200 from account {account_id}")
```

### Checking Balance

```python
balance = bank.get_balance(account_id)
print(f"Current balance for account {account_id} is {balance}")
```

### Running Concurrent Transactions

```python
from thread_manager import run_concurrent_transactions

transactions = [
    {"type": "deposit", "account_id": account_id, "amount": 100},
    {"type": "withdraw", "account_id": account_id, "amount": 50},
    # Add more transactions as needed
]

run_concurrent_transactions(bank, transactions)
```

## Contributing

We welcome contributions to enhance the functionality and performance of this project. To contribute, follow these steps:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Make your changes.
4. Commit your changes (`git commit -am 'Add new feature'`).
5. Push to the branch (`git push origin feature-branch`).
6. Create a new Pull Request.

## License

This project is licensed under the MIT License. See the `LICENSE` file for details.

## Acknowledgments

We thank all contributors and users for their support and feedback.

---

For any questions or suggestions, please open an issue or contact us at [email@example.com](mailto:email@example.com).

---

Happy coding! 🚀
