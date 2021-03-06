package com.frostwire.jlibtorrent.demo;

import com.frostwire.jlibtorrent.AlertListener;
import com.frostwire.jlibtorrent.Entry;
import com.frostwire.jlibtorrent.Session;
import com.frostwire.jlibtorrent.Sha1Hash;
import com.frostwire.jlibtorrent.alerts.Alert;
import com.frostwire.jlibtorrent.alerts.DhtBootstrapAlert;
import com.frostwire.jlibtorrent.alerts.DhtImmutableItemAlert;
import com.frostwire.jlibtorrent.alerts.DhtPutAlert;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author gubatron
 * @author aldenml
 */
public final class DhtImmutable {

    public static void main(String[] args) throws Throwable {

        final Session s = new Session();

        final CountDownLatch signal = new CountDownLatch(2);

        s.addListener(new AlertListener() {

            @Override
            public int[] types() {
                return null;
            }

            @Override
            public void alert(Alert<?> alert) {
                System.out.println(alert.getSwig().message());

                if (alert instanceof DhtBootstrapAlert) {
                    signal.countDown();
                }

                if (alert instanceof DhtPutAlert) {
                    DhtPutAlert put = (DhtPutAlert) alert;
                    System.out.println("PUT ITEM with hash: " + put.getTarget());

                    s.dhtGetItem(put.getTarget());
                }

                if (alert instanceof DhtImmutableItemAlert) {
                    DhtImmutableItemAlert m = (DhtImmutableItemAlert) alert;
                    System.out.println("GET ITEM: " + m.getItem());
                }
            }
        });

        s.dhtGetPeers(new Sha1Hash("86d0502ead28e495c9e67665340f72aa72fe304e"));

        System.out.println("Waiting to DHT bootstrap");

        signal.await(10, TimeUnit.SECONDS);

        System.out.println("Putting item");

        s.dhtPutItem(new Entry("test"));

        System.out.println("Press ENTER to exit");
        System.in.read();
    }
}
