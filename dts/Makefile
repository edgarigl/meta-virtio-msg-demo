xen.dtb: system.dts overlay-virtio-msg.dtsi overlay-xen.dtsi system-user.dtsi
	dtc -I dts -O dtb -o $@ $<

clean:
	$(RM) xen.dtb
