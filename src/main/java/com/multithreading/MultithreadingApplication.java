package com.multithreading;

import com.multithreading.theory.d.daemon.Daemon;
import com.multithreading.theory.e.threadgroup.ThreadGroupUsage;
import com.multithreading.theory.f.threadlocal.with.CheckTL;
import com.multithreading.theory.f.threadlocal.without.Check;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class MultithreadingApplication {

	public static void main(String[] args) {
//		Usage.useThread();
//		SyncUsage.usingCommonObject();
//		SyncUsage.usingDiffObject();
//		CommunicationUsage.print();

//		FileHandlingTheory.useScanner();
//		FileHandlingTheory.usePath();
//		Q1Usage.execute();
//		FileWritingTheory.usingBufferedReader();
//		Daemon.execute();
//		ThreadGroupUsage.execute();

//		CheckTL.execute();
		Check.checkWithoutThreadLocal();

//		SpringApplication.run(MultithreadingApplication.class, args);
	}

}
