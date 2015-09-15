(function() {

	// These tests are functional simulations of
	// user interaction, using syn.js. For more information:
	//
	// @see http://v3.javascriptmvc.com/docs.html#&who=Syn
	// @see http://bitovi.com/blog/2010/07/syn-a-standalone-synthetic-event-library.html

	describe('Interaction', function() {

		describe('clicking control', function() {

			it('should give it focus', function(done) {
				var test = setup_test('<select>' +
					'<option value="a">A</option>' +
					'<option value="b">B</option>' +
				'</select>', {});

				Syn
					.click(test.selectize.$control)
					.delay(0, function() {
						expect(test.selectize.isFocused).to.be.equal(true);
						done();
					});
			});

			it('should open dropdown menu', function(done) {
				var test = setup_test('<select>' +
					'<option value="a">A</option>' +
					'<option value="b">B</option>' +
				'</select>', {});

				Syn
					.click(test.selectize.$control)
					.delay(0, function() {
						expect(test.selectize.isOpen).to.be.equal(true);
						expect(test.selectize.$dropdown.is(':visible')).to.be.equal(true);
						done();
					});
			});

		});

		describe('clicking option', function() {

			it('should select it', function(done) {
				var test = setup_test('<select>' +
					'<option value="">Select an option...</option>' +
					'<option value="a">A</option>' +
					'<option value="b">B</option>' +
				'</select>', {});

				Syn.click(test.selectize.$control).delay(0, function() {
					Syn
						.click($('[data-value="b"]', test.selectize.$dropdown))
						.delay(0, function() {
							expect(test.selectize.$input.val()).to.be.equal('b');
							done();
						});
				});
			});

			it('should close dropdown', function(done) {
				var test = setup_test('<select>' +
					'<option value="">Select an option...</option>' +
					'<option value="a">A</option>' +
					'<option value="b">B</option>' +
				'</select>', {});

				Syn.click(test.selectize.$control).delay(0, function() {
					Syn
						.click($('[data-value="b"]', test.selectize.$dropdown))
						.delay(0, function() {
							expect(test.selectize.isOpen).to.be.equal(false);
							expect(test.selectize.$dropdown.is(':visible')).to.be.equal(false);
							done();
						});
				});
			});

		});

		describe('typing in input', function() {

			it('should filter results', function(done) {
				var test = setup_test('<select>' +
					'<option value="">Select an option...</option>' +
					'<option value="a">A</option>' +
					'<option value="b">B</option>' +
				'</select>', {});

				Syn
					.click(test.selectize.$control)
					.type('a', test.selectize.$control_input)
					.delay(0, function() {
						expect($('[data-value="a"]', test.selectize.$dropdown).length).to.be.equal(1);
						expect($('[data-value="b"]', test.selectize.$dropdown).length).to.be.equal(0);
						done();
					});
			});

			it('should hide dropdown if no results present', function(done) {
				var test = setup_test('<select>' +
					'<option value="">Select an option...</option>' +
					'<option value="a">A</option>' +
					'<option value="b">B</option>' +
				'</select>', {});

				Syn
					.click(test.selectize.$control)
					.type('awaw', test.selectize.$control_input)
					.delay(0, function() {
						expect(test.selectize.isOpen).to.be.equal(false);
						expect(test.selectize.$dropdown.is(':visible')).to.be.equal(false);
						done();
					});
			});

			it('should not hide dropdown if "create" option enabled and no results present', function(done) {
				var test = setup_test('<select>' +
					'<option value="">Select an option...</option>' +
					'<option value="a">A</option>' +
					'<option value="b">B</option>' +
				'</select>', {create: true});

				Syn
					.click(test.selectize.$control)
					.type('awaw', test.selectize.$control_input)
					.delay(0, function() {
						expect(test.selectize.isOpen).to.be.equal(true);
						expect(test.selectize.$dropdown.is(':visible')).to.be.equal(true);
						done();
					});
			});

			it('should restore dropdown visibility when backing out of a query without results (backspace)', function(done) {
				var test = setup_test('<select>' +
					'<option value="">Select an option...</option>' +
					'<option value="a">A</option>' +
					'<option value="b">B</option>' +
				'</select>', {});

				Syn
					.click(test.selectize.$control)
					.type('awf', test.selectize.$control_input)
					.type('\b\b\b', test.selectize.$control_input)
					.delay(0, function() {
						expect(test.selectize.isOpen).to.be.equal(true);
						expect(test.selectize.$dropdown.is(':visible')).to.be.equal(true);
						done();
					});
			});

			it('should move caret when [left] or [right] pressed', function(done) {
				var test = setup_test('<input type="text" value="a,b,c,d">', {create: true});

				Syn
					.click(test.selectize.$control)
					.type('[left][left]whatt', test.selectize.$control_input)
					.delay(0, function() {
						expect(test.selectize.caretPos).to.be.equal(2);
						done();
					});
			});

		});

		describe('blurring the input', function() {
			it('should close dropdown when createOnBlur is true', function(done) {
				var test = setup_test('<select multiple="multiple">' +
					'<option></option>' +
					'<option value="a">A</option>' +
					'<option value="b">B</option>' +
				'</select>', {
					createOnBlur: true,
					create: function(value){
						return {
							value: value,
							text: value
						};
					}
				});

				Syn
					.click(test.selectize.$control)
					.type('fooo', test.selectize.$control_input)
					.delay(0, function() {
						expect(test.selectize.isOpen).to.be.equal(true);
						expect(test.selectize.$dropdown.is(':visible')).to.be.equal(true);

						Syn
							.click($("#mocha")[0])
							.delay(0, function() {
								expect(test.selectize.isOpen).to.be.equal(false);
								expect(test.selectize.$dropdown.is(':visible')).to.be.equal(false);
								done();
							});
					});

			});
		});

	});

})();