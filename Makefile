.PHONY: fmt
fmt:
	clojure -M:fmt

.PHONY: clean
clean:
	rm -rf classes
	rm -rf target
